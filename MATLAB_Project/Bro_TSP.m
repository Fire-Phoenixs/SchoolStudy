function tsp_31_cities_battle_royale()

    [~, cities] = Read('a280.tsp');

    fprintf('=== TSP问题求解 ===\n');
    fprintf('城市数量: %d\n', size(cities, 1));

    % 算法参数
    pop_size = 100;
    max_iter = 10000;
    damage_threshold = 3;
    learning_rate = 0.85;
    tournament_size = 5;

    distance_matrix = calculate_distance_matrix(cities);

    num_cities = size(cities, 1);
    population = initialize_population(pop_size, num_cities);
    damage = zeros(pop_size, 1);
    fitness = zeros(pop_size, 1);

    for i = 1:pop_size
        fitness(i) = calculate_fitness_with_matrix(population(i,:), distance_matrix);
    end

    [best_fitness, best_idx] = min(fitness);
    best_solution = population(best_idx,:);
    convergence_curve = zeros(max_iter, 1);
    convergence_curve(1) = best_fitness;

    fprintf('初始最优路径长度: %.2f\n', best_fitness);
    fprintf('开始优化...\n\n');

    start_time = tic;

    for iter = 1:max_iter
        shrink_factor = (iter/max_iter)^2;

        for i = 1:pop_size
            current_solution = population(i,:);
            current_fitness = fitness(i);

            opponent_idx = select_opponent(fitness, i, tournament_size);
            opponent_fitness = fitness(opponent_idx);

            if current_fitness < opponent_fitness
                damage(opponent_idx) = damage(opponent_idx) + 1;
                new_solution = learn_from_elite(current_solution, best_solution, learning_rate);
            else
                damage(i) = damage(i) + 1;
                new_solution = learn_from_elite(current_solution, best_solution, learning_rate * 0.7);
            end

            if rand() < shrink_factor
                new_solution = enhanced_local_search(new_solution, distance_matrix);
            else
                new_solution = local_search(new_solution);
            end

            new_fitness = calculate_fitness_with_matrix(new_solution, distance_matrix);

            if new_fitness < current_fitness || (new_fitness >= current_fitness && rand() < 0.05)
                population(i,:) = new_solution;
                fitness(i) = new_fitness;
            end

            if damage(i) >= damage_threshold
                population(i,:) = generate_random_solution(num_cities);
                fitness(i) = calculate_fitness_with_matrix(population(i,:), distance_matrix);
                damage(i) = 0;
            end
        end

        [current_best, current_idx] = min(fitness);
        if current_best < best_fitness
            best_fitness = current_best;
            best_solution = population(current_idx,:);

            if mod(iter, 200) == 0
                fprintf('迭代 %d: 最优路径长度 = %.2f\n', iter, best_fitness);
            end

        end

        convergence_curve(iter) = best_fitness;

        if mod(iter, 500) == 0
            fprintf('进度: %d/%d (%.1f%%), 当前最优: %.2f\n', ...
                iter, max_iter, iter/max_iter*100, best_fitness);
        end
    end

    computation_time = toc(start_time);

    fprintf('\n=== 优化完成 ===\n');
    fprintf('计算时间: %.2f 秒\n', computation_time);
    fprintf('最终最优路径长度: %.2f\n', best_fitness);
    fprintf('最优路径顺序:\n');

    figure('Position', [100, 100, 1400, 600]);

    subplot(1,2,1);
    plot(convergence_curve, 'LineWidth', 2);
    xlabel('迭代次数');
    ylabel('路径长度');
    title('大逃杀算法收敛曲线');
    grid on;

    subplot(1,2,2);
    plot_tsp_solution(best_solution, cities,best_fitness);

    fprintf('\n图形窗口已显示最优路径！\n');
end

% ===== 辅助函数 =====

function population = initialize_population(pop_size, num_cities)
    population = zeros(pop_size, num_cities);
    for i = 1:pop_size
        population(i,:) = randperm(num_cities);
    end
end

function solution = generate_random_solution(num_cities)
    solution = randperm(num_cities);
end

function fitness = calculate_fitness_with_matrix(solution, distance_matrix)
    total_distance = 0;
    n = length(solution);

    for i = 1:n-1
        total_distance = total_distance + distance_matrix(solution(i), solution(i+1));
    end
    total_distance = total_distance + distance_matrix(solution(end), solution(1));

    fitness = total_distance;
end

function dist_matrix = calculate_distance_matrix(cities)
    n = size(cities, 1);
    dist_matrix = zeros(n, n);

    for i = 1:n
        for j = i+1:n
            dist = sqrt(sum((cities(i,:) - cities(j,:)).^2));
            dist_matrix(i,j) = dist;
            dist_matrix(j,i) = dist;
        end
    end
end

function opponent_idx = select_opponent(fitness, current_idx, tournament_size)
    pop_size = length(fitness);
    candidates = setdiff(1:pop_size, current_idx);
    tournament_indices = candidates(randperm(length(candidates), min(tournament_size, length(candidates))));
    [~, best_idx] = min(fitness(tournament_indices));
    opponent_idx = tournament_indices(best_idx);
end

function new_solution = learn_from_elite(current, elite, learning_rate)
    n = length(current);
    new_solution = current;

    if rand() < learning_rate
        % OX交叉
        cut1 = randi([1, n-2]);
        cut2 = randi([cut1+1, n-1]);
        segment = elite(cut1:cut2);
        new_solution(cut1:cut2) = segment;
        new_solution = repair_solution_ox(new_solution, current, cut1, cut2);
    end
end

function solution = repair_solution_ox(new_sol, old_sol, start, finish)
    n = length(new_sol);
    solution = zeros(1, n);
    solution(start:finish) = new_sol(start:finish);
    idx = 1;
    for i = 1:n
        if idx == start
            idx = finish + 1;
        end
        if idx > n
            break;
        end

        current_city = old_sol(i);
        if ~ismember(current_city, solution)
            solution(idx) = current_city;
            idx = idx + 1;
            if idx == start
                idx = finish + 1;
            end
        end
    end
end

function solution = local_search(solution)
    n = length(solution);
    i = randi([1, n-3]);
    j = randi([i+2, n-1]);

    new_solution = solution;
    new_solution(i+1:j) = solution(j:-1:i+1);
    solution = new_solution;
end

function solution =  enhanced_local_search(solution, distance_matrix)
    n = length(solution);
    best_solution = solution;
    best_fitness = calculate_fitness_with_matrix(solution, distance_matrix);
    for k = 1:5
        temp_solution = solution;

        switch randi([1, 3])
            case 1  % 2-opt
                i = randi([1, n-3]);
                j = randi([i+2, n-1]);
                temp_solution(i+1:j) = solution(j:-1:i+1);

            case 2  % 交换
                i = randi([1, n-1]);
                j = randi([1, n-1]);
                temp = temp_solution(i);
                temp_solution(i) = temp_solution(j);
                temp_solution(j) = temp;

            case 3  % 反转
                i = randi([1, n-2]);
                j = randi([i+1, n-1]);
                temp_solution(i:j) = solution(j:-1:i);
        end

        temp_fitness = calculate_fitness_with_matrix(temp_solution, distance_matrix);
        if temp_fitness < best_fitness
            best_solution = temp_solution;
            best_fitness = temp_fitness;
        end
    end

    solution = best_solution;
end

function plot_tsp_solution(solution, cities, fitness)
    n = length(solution);
    tour = [solution, solution(1)];
    scatter(cities(:,1), cities(:,2), 100, 'b', 'filled');
    hold on;

    for i = 1:n
        city1 = cities(tour(i),:);
        city2 = cities(tour(i+1),:);
        plot([city1(1), city2(1)], [city1(2), city2(2)], 'r-', 'LineWidth', 2);
    end

    plot(cities(solution(1),1), cities(solution(1),2), 's', 'MarkerSize', 12, ...
         'MarkerFaceColor', 'green', 'MarkerEdgeColor', 'black', 'LineWidth', 2);
    plot(cities(solution(end),1), cities(solution(end),2), 's', 'MarkerSize', 12, ...
         'MarkerFaceColor', 'red', 'MarkerEdgeColor', 'black', 'LineWidth', 2);

    xlabel('X坐标');
    ylabel('Y坐标');
    title(sprintf('最优路径 (总长度: %.2f)', fitness));
    grid on;
    axis equal;

end

function [n_citys,city_position] = Read(filename)
fid = fopen(filename,'rt');
location=[];
A = [1 2];
tline = fgetl(fid);
while ischar(tline)
    if(strcmp(tline,'NODE_COORD_SECTION'))
        while ~isempty(A)
            A=fscanf(fid,'%f',[3,1]);
            if isempty(A)
                break;
            end
            location=[location;A(2:3)'];
        end
    end
    tline = fgetl(fid);
    if strcmp(tline,'EOF')
        break;
    end
end
[m,~]=size(location);
n_citys = m;
city_position=location;
fclose(fid);
end

tsp_31_cities_battle_royale();
