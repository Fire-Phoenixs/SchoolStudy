function tsp_31_cities_battle_royale()    %%定义算法主函数
    
    %% 导入31座省会城市（x，y）坐标数据，创建一个31行2列的矩阵
    cities = [
        1304, 2312;
        3639, 1315;
        4177, 2244;
        3712, 1399;
        3488, 1535;
        3326, 1556;
        3238, 1229;
        4196, 1004;
        4312, 790;
        4386, 570;
        3007, 1970;
        2562, 1756;
        2788, 1491;
        2381, 1676;
        1332, 695;
        3715, 1678;
        3918, 2179;
        4061, 2370;
        3780, 2212;
        3676, 2578; 
        4029, 2838;
        4263, 2931;
        3429, 1908;
        3507, 2367;
        3394, 2643;
        3439, 3201;
        2935, 3240;
        3140, 3550;
        2545, 2357;
        2778, 2826;
        2370, 2975
    ];
    %%输出题头和城市数量，由size函数导出矩阵第一维的值（即31行）
    fprintf('=== 全国31个省会城市TSP问题求解 ===\n');
    fprintf('城市数量: %d\n', size(cities, 1));
    
    %% 大逃杀算法（BRO）参数设置
    pop_size = 100;          %% 初始化的士兵数量
    max_iter = 5000;         %% 最大迭代次数
    damage_threshold = 3;    %% 损伤阈值，即每个士兵在受到三次伤害之后死亡并重生
    learning_rate = 0.85;    %% 学习率，即有85%的概率向出现的精英学习
    tournament_size = 5;     %% 每次从五个候选者中选择对手比较解的值并造成伤害
    
    %% 205行的自定义公式，负责计算任意两个城市之间的距离，方便后续进行调用，减少计算时间
    distance_matrix = calculate_distance_matrix(cities);
    
    %% 初始化种群数据
    num_cities = size(cities, 1);  %%将城市数量赋值给该变量
    population = initialize_population(pop_size, num_cities);  %%构建士兵持有解矩阵
    damage = zeros(pop_size, 1);   %%初始化损伤值数组，生成pop_size行，1列的零矩阵
    fitness = zeros(pop_size, 1);   %%初始化适应度数组，生成pop_size行，1列的零矩阵
    
    % 计算所有士兵的初始适应度
    for i = 1:pop_size
        fitness(i) = calculate_fitness_with_matrix(population(i,:), distance_matrix);
    end
    
    % 记录最佳解
    [best_fitness, best_idx] = min(fitness);  %%min()函数返回两个值，第一个为最小值，第二个为最小值在矩阵中的索引
    best_solution = population(best_idx,:);  %%纪录当前最好的巡演顺序
    convergence_curve = zeros(max_iter, 1);  %%建立一个max_iter行，1列的零矩阵以储存最后可视化图像的数据
    convergence_curve(1) = best_fitness;  %%将该零数组的第一位赋值当前最好的适应度
    
    %%可视化输出
    fprintf('初始最优路径长度: %.2f\n', best_fitness);
    fprintf('开始优化...\n\n');
    
    %% 主循环
    %%启动秒表，tic意味着计时开始
    start_time = tic;
    
    for iter = 1:max_iter  %%进行max_iter次的遍历，由迭代初始参数决定
        shrink_factor = (iter/max_iter)^2;  %%安全区收缩程度，由循环进度的平方决定，为了在初期给足探索时间，在后期加速收敛
        
        for i = 1:pop_size  %%遍历每一个士兵进行战斗过程
            current_solution = population(i,:);  %%纪录当前士兵的路线
            current_fitness = fitness(i);  %%纪录当前士兵的适应度
            
            % 选择攻击目标
            opponent_idx = select_opponent(fitness, i, tournament_size);  %%在fitness中为i挑选tournament_size个随机候选对手，并从挑选出的对手中选出一个适应度最好的
            opponent_fitness = fitness(opponent_idx);  %%取得对手的适应度
            
            % 战斗过程
            if current_fitness < opponent_fitness  %%如果对手的适应度不如自己，则攻击成功
                damage(opponent_idx) = damage(opponent_idx) + 1;  %%其对手的损伤值+1
                new_solution = learn_from_elite(current_solution, best_solution, learning_rate);  %%当前解以正常学习率向精英解学习
            else
                % 如果自己的适应度不如对手，则攻击失败
                damage(i) = damage(i) + 1;  %%自己的损伤值+1
                new_solution = learn_from_elite(current_solution, best_solution, learning_rate * 0.7);  %%当前解以较低概率向精英解学习
            end
            
            % 安全区收缩 - 增强局部搜索
            if rand() < shrink_factor  %%产生一个0-1的随机数
                new_solution = enhanced_local_search(new_solution, distance_matrix);  %%进行增强搜索
            else
                new_solution = local_search(new_solution);  %%进行一般搜索
            end
            
            new_fitness = calculate_fitness_with_matrix(new_solution, distance_matrix);  %%计算新解适应度
            
            % 更新解
            if new_fitness < current_fitness || (new_fitness >= current_fitness && rand() < 0.05)  %%在新路线比当前路线更好接受新路线或者5%的概率接受一个更差的新路线
                population(i,:) = new_solution;  
                fitness(i) = new_fitness;
            end
            
            % 检查重生
            if damage(i) >= damage_threshold  %%如果损伤值达到阈值
                population(i,:) = generate_random_solution(num_cities);  %%新生成一个序列
                fitness(i) = calculate_fitness_with_matrix(population(i,:), distance_matrix);  %%计算新序列的适应度
                damage(i) = 0;  %%重新设置适应度
            end
        end
        
        [current_best, current_idx] = min(fitness);  %%找到当前路线最优的个体，纪录其编号和最短距离值
        if current_best < best_fitness  %%如果当前最优解优于历史最优解
            best_fitness = current_best;
            best_solution = population(current_idx,:);  %%更新最优距离值并更新路线
            
            if mod(iter, 200) == 0
                fprintf('迭代 %d: 最优路径长度 = %.2f\n', iter, best_fitness);
            end
        end
        
        convergence_curve(iter) = best_fitness;
        
        % 显示进度
        if mod(iter, 500) == 0  %%当计数达到两百的倍数时，打印进度信息
            fprintf('进度: %d/%d (%.1f%%), 当前最优: %.2f\n', ...
                iter, max_iter, iter/max_iter*100, best_fitness);
        end
    end
    
    computation_time = toc(start_time);  %%计时器结束
    
    %% 显示结果
    fprintf('\n=== 优化完成 ===\n');
    fprintf('计算时间: %.2f 秒\n', computation_time);
    fprintf('最终最优路径长度: %.2f\n', best_fitness);
    fprintf('最优路径顺序:\n');
    
    % 显示城市访问顺序
    city_names = {'北京','天津','石家庄','太原','呼和浩特','沈阳','长春','哈尔滨',...
                 '上海','南京','杭州','合肥','福州','南昌','济南','郑州','武汉',...
                 '长沙','广州','南宁','海口','重庆','成都','贵阳','昆明','拉萨',...
                 '西安','兰州','西宁','银川','乌鲁木齐'};
    
    %%每五个一行循环打印城市名称
    for i = 1:num_cities
        fprintf('%s ', city_names{best_solution(i)});
        if mod(i, 5) == 0
            fprintf('\n');
        end
    end
    fprintf('%s\n', city_names{best_solution(1)});  %%打印起点城市
    
    %% 绘制结果
    figure('Position', [100, 100, 1400, 600]);  %%在屏幕（100，100）处创建一个宽1400像素，高600像素的图形窗口
    
    % 绘制收敛曲线
    subplot(1,2,1);  %%第一行第二列的第一个子图
    plot(convergence_curve, 'LineWidth', 2);  %%线条加粗
    xlabel('迭代次数');
    ylabel('路径长度');
    title('大逃杀算法收敛曲线');
    grid on;
    
    % 绘制最优路径图
    subplot(1,2,2);   %%第一行第二列的第二个子图
    plot_tsp_solution(best_solution, cities, city_names, best_fitness);  %%显示最优路线图
    
    fprintf('\n图形窗口已显示最优路径！\n');
end

%% 辅助函数
%%创建一个矩阵以存放士兵所持有的解
function population = initialize_population(pop_size, num_cities)
    population = zeros(pop_size, num_cities);  %%创建一个pop_size行，mun_cities列的全零矩阵
    for i = 1:pop_size  %%为每一个士兵生成一个随机的路线
        population(i,:) = randperm(num_cities);  %%randperm函数将随机生成一个从1-31的随机数串,决定该士兵的持有解
    end
end
%%随机生成一个城市序列
function solution = generate_random_solution(num_cities)
    solution = randperm(num_cities);  %%生成一个包含所有城市的序列
end

%%适应度计算函数，fitness是士兵所持有的解，即总距离
function fitness = calculate_fitness_with_matrix(solution, distance_matrix)
    total_distance = 0;  %%初始化总距离
    n = length(solution);  %%获取城市总数，赋值给变量n
    
    for i = 1:n-1
        total_distance = total_distance + distance_matrix(solution(i), solution(i+1));  %%计算该可能解从第一座城市到最后一座城市的总距离
    end
    total_distance = total_distance + distance_matrix(solution(end), solution(1));  %%计算最后一座城市到第一座城市的距离，完成闭环
    
    fitness = total_distance;  %%适应度即为总距离
end
%%城市距离计算函数，是一个经典阵计算函数
function dist_matrix = calculate_distance_matrix(cities)
    n = size(cities, 1);%%获得矩阵的行数，即将城市总量纪录在变量n中
    dist_matrix = zeros(n, n);%%创建一个n*n的零矩阵，用于储存城市间的距离
    
    for i = 1:n   %%将i从1到n遍历
        for j = i+1:n   %%将j从i+1到n便利，以此实现只计算左上角的城市距离，减少一半的计算时间
            dist = sqrt(sum((cities(i,:) - cities(j,:)).^2));   %%(i,:)意味着取第i行的所有列里的值，即第i/j个城市的(x,y)坐标，这行代码计算了两个城市之间的欧几里得距离            
            dist_matrix(i,j) = dist;  
            dist_matrix(j,i) = dist;   %%计算后的结果进行对角线赋值
        end
    end
end

%%为士兵挑选对手的函数
function opponent_idx = select_opponent(fitness, current_idx, tournament_size)
    pop_size = length(fitness);  %%查看当前有多少个候选解可挑选为对手
    candidates = setdiff(1:pop_size, current_idx);  %%将1-pop_size赋值给candidates，但因为setdiff()函数排除了current_idx，也就是当前士兵，保证不挑选待对战的士兵自身为对手
    tournament_indices = candidates(randperm(length(candidates), min(tournament_size, length(candidates))));
    %%randperm(length(candidates)意味着将所有对手随机打乱
    %%min(tournament_size,length(candidates))意味着确定参与人数，若人数小于tournament_size则全部参加，若大于tournament_size则挑选tournament_size个人参加
    %%即从被打乱的候选士兵名单中挑选tournament_size个人参加
    [~, best_idx] = min(fitness(tournament_indices));  %%从名单中挑选适应度最好的解的名单编号，~意味着不关心这个解的适应度
    opponent_idx = tournament_indices(best_idx);  %%提取出这个编号对应的士兵编号(上一行挑选的是名单中的编号，不是士兵的编号)，赋值
end

%%向精英解学习的函数
function new_solution = learn_from_elite(current, elite, learning_rate)
    n = length(current);  %%确定所经过的城市数量，即31个
    new_solution = current;  %%让新方法暂时保持旧方法不改变
    
    if rand() < learning_rate  %%rand()产生一个0-1之间的随机数，与学习率比较，如果小于学习率，开始学习过程，若大于学习率，则不进行改动
        % 顺序交叉(OX)过程
        cut1 = randi([1, n-2]);  %%在1-29之间选择一个切点
        cut2 = randi([cut1+1, n-1]);  %%在cut1+1-30之间选择一个切点
        segment = elite(cut1:cut2);  %%复制精英解cut1-cut2之间的路径
        new_solution(cut1:cut2) = segment;  %%将旧方法cut1-cut2之间的路径改为学习路径
        new_solution = repair_solution_ox(new_solution, current, cut1, cut2);  %%因为可能出现路径重复，进行路径修复
    end
end

%%路径修复函数
function solution = repair_solution_ox(new_sol, old_sol, start, finish)
    n = length(new_sol);  %%获取城市总数
    solution = zeros(1, n);  %%创建一个1行，n列的零矩阵来储存修复好的方法
    solution(start:finish) = new_sol(start:finish);  %%将已经确定好的学习精英解的片段复制过去
    idx = 1;  %%初始化变量
    for i = 1:n  %%从原方案的第一个城市开始，遍历到最后一个城市，保证了没有被学习的城市仍按照之前的相对顺序排列
        if idx == start
            idx = finish + 1;  %%如果遍历到学习段的开头，那就跳过然后从学习段结尾开始
        end
        if idx > n  %%如果遍历结束，推出循环
            break;
        end
        
        current_city = old_sol(i);  %%检查旧方案中的第i个城市
        if ~ismember(current_city, solution)  %%~ismember(x, y)意味着检查x是否在y中，这里检测第i个城市是否是学习段中的城市
            solution(idx) = current_city;  %%如果没有就填写到当前空位
            idx = idx + 1;  %%准备填写下一个空位
            if idx == start  %%如果下一个空位是学习段的起始点
                idx = finish + 1;  %%那就从学习段的终点开始
            end
        end
    end
end

% 2-opt局部搜索函数
function solution = local_search(solution)
    n = length(solution);  %%获取解向量的长度
    i = randi([1, n-3]);  %%随机生成第一个切割点
    j = randi([i+2, n-1]);  %%在第一个切割点后随机生成第一个切割点，并保证两个切割点之间至少有三个城市且不能选择最后一个点
    
    new_solution = solution;  %%创建一个解的副本，避免直接修改原解
    new_solution(i+1:j) = solution(j:-1:i+1);  %%选择原解中i+1到j的片段，并将其倒序排列后赋值给副本
    solution = new_solution;  %%将副本变成正式解
end

% 增强的局部搜索函数，会尝试多种邻域操作
function solution =  enhanced_local_search(solution, distance_matrix)
    n = length(solution);  %%获取解的长度
    best_solution = solution;  %%纪录当前最优解，初始为输入解
    best_fitness = calculate_fitness_with_matrix(solution, distance_matrix);  %%计算最优解的适应度
    for k = 1:5  %%尝试五次邻域搜索
        temp_solution = solution;  %%备份原路线，防止直接修改
        
        switch randi([1, 3])
            case 1  %%2-opt局部搜索函数
                i = randi([1, n-3]);
                j = randi([i+2, n-1]);
                temp_solution(i+1:j) = solution(j:-1:i+1);
                
            case 2 % 节点交换
                i = randi([1, n-1]);
                j = randi([1, n-1]);  %%随机选择两个城市
                temp = temp_solution(i);  %%暂时储存城市i
                temp_solution(i) = temp_solution(j);  %%将城市i换成城市j
                temp_solution(j) = temp;  %%将城市i换成城市j
                
            case 3 % 将随机片段中的城市访问顺序逆转
                i = randi([1, n-2]);
                j = randi([i+1, n-1]);
                temp_solution(i:j) = solution(j:-1:i);
        end
        
        temp_fitness = calculate_fitness_with_matrix(temp_solution, distance_matrix);  %%评估适应度
        if temp_fitness < best_fitness  %%若新路线的适应度更优秀，则将临时储存的路线替换为新路线，同时给更替适应度值
            best_solution = temp_solution;
            best_fitness = temp_fitness;
        end
    end
    
    solution = best_solution;  %%将原路线更换为找到的最优路线
end

function plot_tsp_solution(solution, cities, city_names, fitness)
    n = length(solution);
    tour = [solution, solution(1)];  %%在路径末尾添加起点城市，闭合路径
    scatter(cities(:,1), cities(:,2), 100, 'b', 'filled');  %%用蓝色实心圆点绘制所有城市位置，点的大小为100
    hold on;  %%保持图形，继续添加元素
    
    %用线宽为2的红色实线链接所有城市
    for i = 1:n
        city1 = cities(tour(i),:);
        city2 = cities(tour(i+1),:);
        plot([city1(1), city2(1)], [city1(2), city2(2)], 'r-', 'LineWidth', 2);
    end
    
    % 用带黑色边框的绿色方块标记起点，用带黑色边框的红色方块标记终点
    plot(cities(solution(1),1), cities(solution(1),2), 's', 'MarkerSize', 12, ...
         'MarkerFaceColor', 'green', 'MarkerEdgeColor', 'black', 'LineWidth', 2);
    plot(cities(solution(end),1), cities(solution(end),2), 's', 'MarkerSize', 12, ...
         'MarkerFaceColor', 'red', 'MarkerEdgeColor', 'black', 'LineWidth', 2);
    
    %在每个城市位置右上方偏移(50,50)处添加字体大小为8的城名称
    for i = 1:n
        text(cities(i,1)+50, cities(i,2)+50, city_names{i}, 'FontSize', 8);
    end
    
    xlabel('X坐标');
    ylabel('Y坐标');
    title(sprintf('全国31个省会城市最优路径 (总长度: %.2f)', fitness));
    grid on;  %%添加网格线
    axis equal;  %%确保坐标轴比例一致
    
    legend('城市', '路径', '起点', '终点', 'Location', 'best');  %%创建图例
end


tsp_31_cities_battle_royale();  %%运行算法