"""
Write a program that is able to 
determine if a given number is prime
"""

def find_is_prime(number):
    if number <= 2:
        return False
    for factor in range(2, number):
        if number %  factor == 0:
            return False
    return True

number = 8
is_prime = find_is_prime(number)
print(str(number) + " is prime: ", is_prime)


