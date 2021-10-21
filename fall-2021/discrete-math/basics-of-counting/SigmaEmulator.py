"""
A program that makes calculation of 
and sigma notation
"""


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

result = sigma(1, 6, func5)
print(result)

