"""
A program that makes calculation of 
and sigma notation
"""

import math

# factorial 
def fac(n): 
    if n == 0 or n == 1:
        return 1
    return n * fac(n - 1)

# permutation
def per(n, m):
    return fac(n) / fac(n - m)

# combination 
def com(n, m):
    return per(n, m) / fac(m)



# sum up all the output of function
# from start to end input(included)
def sigma(start, end, function): 
    sum = 0
    for i in range(start, end + 1):
        sum += function(i)
    return sum

# x^2 + 1
def func1(x):
    return x ** 2 + 1

def func2(x):
    return x ** 3 - 1

def func3(x):
    return 1 + (-1) ** x

def func4(x):
    return (-1) ** x

def func4_helper(n):
    return 2 * n

def func5(x):
    return x * ((-1) ** x)

def func6(n):
    def result_func(x):
        return 1 / (fac(x) * fac(n - x))
    return result_func 

def func7(x):
    return com(50, x) * (8 ** x)

result = sigma(0, 50, func7) 
print(math.pow(result, 1/100))



