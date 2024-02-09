# classic recursive solution to find
# nth fibbonacci number
def fib(n):
    # Check if input is 0 then it will
    # print incorrect input
    if n < 0:
        print("Incorrect input")
    # Check if n is 0
    # then it will return 0
    elif n == 0:
        return 0
    # Check if n is 1,2
    # it will return 1
    elif n == 1 or n == 2:
        return 1
    else:
        return fib(n-1) + fib(n-2)

# closed formula which computes fibbonacci
def fib_closed(N):
    g = (1 + 5**.5) / 2  # Golden ratio.
    return int((g**N - (1-g)**N) / 5**.5)

# fibbonacci value, n
n = 1000 
print(fib_closed(n))
