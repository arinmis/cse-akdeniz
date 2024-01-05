from sys import argv 
from time import time

"""
returns elapsed time and output of function 
called with list of given parameters
"""
def calc_time_elapsed(func, params):
    start_time = time()
    result = func(*params)
    end_time = time()
    return (result, "%.3f" % (end_time - start_time)) 

"""
n = 0, 1
n = 1, 1
n > 1, fib(n - 1) + fib(n - 2)
"""
def fib(n):
    if n <= 1:
        return n 
    table = [0] * (n + 1)
    table[1] = 1
    for i in range(2, len(table)):
        table[i] = table[i - 1] + table[i - 2]
    return table[n]


# classic unoptimize recursive solution 
def fib_slow(n):
    if n <= 1:
        return n 
    return fib_slow(n-1) + fib_slow(n-2)

"""
closed formula which computes fibbonacci
in constant time O(1)
formula is derived from generating function
"""
def fib_closed(N):
    g = (1 + 5**.5) / 2  # Golden ratio.
    return int((g**N - (1-g)**N) / 5**.5)


if __name__ == "__main__":
    if not len(argv) == 2:
        raise Exception("pass a number  as command line arg to compute fibonacci")
    n = int(argv[1])
    result, elapsed_time = calc_time_elapsed(fib_closed, [n])
    print(f"fastest\n\tresult: {result}, elapsed_time: {elapsed_time}\n")
    result, elapsed_time = calc_time_elapsed(fib, [n])
    print(f"optimized\n\tresult:{result}, elapsed_time: {elapsed_time}\n")
    result, elapsed_time = calc_time_elapsed(fib_slow, [n])
    print(f"slowest:\n\tresult: {result}, elapsed_time: {elapsed_time}\n")

