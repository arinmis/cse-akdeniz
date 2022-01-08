"""
Write a computer program (or develop an algorithm)
to determine whether there is a three-digit integer
abc (= 100a + 10b + c) where abc = a! + b! + c!.
"""

def fac(n):
    if n == 0:
        return 1
    return n * fac(n-1)


def get_fac_sum():
    sum_list = []
    num = 100
    
    for x in range(100, 1000):
        c = num % 10
        b = (num // 10 ) % 10
        a = (num // 100)
        
        if num == (fac(a) +fac(b) + fac(c)):
            sum_list.append(num)
        
        num += 1

    return sum_list

result = get_fac_sum() 
if (len(result) > 0):
    print("yes there is!")
print(result)

