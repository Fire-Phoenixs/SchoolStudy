# Task 1:
# Write a function is_prime(n) that checks whether an integer is prime or not.
# Return either true or false, as appropriate.

def is_prime(n):
    if n <= 1:
        return False
    if n <= 3 and n > 1:
        return True
    if n %2 == 0 or n % 3 == 0:
        return False
    i = 5
    while i * i <= n:
        if n % i == 0 or n % (i + 2) == 0:
            return False
        i += 6
    return True
             
print("testing task 1 (primality test):")
def test1(n):
    print("is_prime(", n, ") = ", is_prime(n), sep='')
test1(10) # false
test1(11) # true
test1(1) # false
test1(-2) # false
test1(111) # false
test1(17) # true
print("======================================================================")
         
# Task 2:
# Write a function print_prime_factors(n, repeat) that prints out the prime factors of n, one on each line.
# If repeat is true, each factors should be printed as many times as it appears in the prime decomposition of n.
# If repeat is false, each factor should be printed oly once.

def print_prime_factors(n, repeat):
    pass

print("Testing task 2 (prime factors):")
def test2(n, repeat):
    print("prime factors of ", n, "(with", end='')
    if not repeat:
        print("out", end='')
    print(" repetition):")
    print_prime_factors(n, repeat)
test2(156, True) # 2 2 3 13
test2(156, False) # 2 3 13
test2(157932720, True) # 2 2 3 3 3 5 11 17 17 23
test2(157932720, False) # 2 3 5 11 17 23
test2(1024, False) # 2
test2(17, True) # 17
print("======================================================================")        

# Task 3:
# Write a function that takes a list of integers and returns how many prime numbers are in that list

def how_many_primes(lst):
    pass

print("Testing task 3 (counting primes):")
def test3(lst):
    print(lst, "contains", how_many_primes(lst), "prime(s).")
test3([1,2,3,4,5,6,7,8,9,10]) # 4
test3([4, 9, 25, 121, 117]) # 0
test3([4, 9, 25, 121, 17, 117]) # 1
print("======================================================================")

# Task 4:
# Write a function that takes a list of integers and returns a list containing only non-prime numbers from the list received as an argument

def nonprimes(lst):
    pass

print("Testing task 4 (filtering non-primes):")
def test4(lst):
    print(lst, "→", nonprimes(lst))
test4([1,2,3,4,5,6,7,8,9,10]) # [1,4,6,8,9,10]
test3([4, 9, 25, 121, 117]) # 0
test3([4, 9, 25, 121, 17, 117]) # 1
print("======================================================================")
   
    
# Task 5:
# Write a function that returns the prime decomposition of a positive integer, represented as a list.
# (Prime decomposition od a prime consists of the prime itself. prime decomposition of 1 is the empty list.)

def prime_decomposition(n):
    pass

print("Testing task 5 (prime decomposition):")
def test5(n):
    print(n, "→", prime_decomposition(n))
test5(156) # [2, 2, 3, 13]
test5(157932720) # [2, 2, 3, 3, 3, 5, 11, 17, 17, 23]
test5(1024) # [2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
test5(17) # [17]
test5(1) # []
print("======================================================================")

# Task 6:
# Write a function that returns the prime decomposition of a positive integer as a list of pairs,
# where the first coordinate of a pair is a prime factor, and the second coordinate is its multiplicity.

def prime_decomposition_pairs(n):
    pass

print("Testing task 6 (prime decomposition as list of pairs):")
def test6(n):
    print(n, "→", prime_decomposition_pairs(n))
test6(156) # [(2,2), (3,1), (13,1)]
test6(157932720) # [(2,2), (3,3), (5,1), (11,1), (17,2), (23,1)]
test6(1024) # [(2, 10)]
test6(17) # [(17,1)]
test6(1) # []
print("======================================================================")

# Task 7: 
# Write a function that given a prime decomposition of the form the prime_decomposition_pairs produces, 
# calculates the number corresponding to that prime decomposition.
# (Hint: exponentition can be calculated using the ** operator, i.e., x**y means xʸ.) 

def number_from_prime_decomposition(decomposition):
    pass

print("Testing task 7 (number from prime decomposition):")
def test7(decomposition):
    print(decomposition, "→", number_from_prime_decomposition(decomposition))
test7([(2,2), (3,1), (13,1)]) # 156
test7([(2,2), (3,3), (5,1), (11,1), (17,2), (23,1)]) # 157932720
test7([(2,10)]) # 1024
test7([]) # 1
print("======================================================================")

    
# Task 8:
# write a function that, given a list of pairs of integers, checks whether such a list represents a prime decomposition
# in the sense described in task 6, i.e., check that:
# - first coordinates of all the pairs are prime numbers
# - second coordinates are positive integers
# - there are no repetitions among the first coordinates

def is_prime_decomposition(decomposition):
        pass    

print("Testing task 8 (checking prime decompositions):")
def test8(decomposition):
    print(decomposition, "→", is_prime_decomposition(decomposition))
test8([(2,2), (3,1), (13,1)]) # true
test8([(2,2), (3,0), (13,1)]) # false
test8([(2,2), (3,3), (5,1), (11,1), (17,2), (23,1)]) # true
test8([(2,2), (3,3), (5,1), (11,1), (3,2), (23,1)]) # false
test8([(2,2), (3,3), (6,1), (11,1), (17,2), (23,1)]) # false
test8([(2,10)]) # true
test8([]) # true
print("======================================================================")

