import random
from time import time

"""
returns elapsed time and output of function 
called with list of given parameters
"""
def calc_time_elapsed(func, params):
    start_time = time()
    result = func(*params)
    end_time = time()
    return (result, end_time - start_time) 

def generate_random_string(length):
    letters = "abcde" # string.ascii_lowercase
    result_str = ''.join(random.choice(letters) for i in range(length))
    return result_str
    
def generate_input_sizes(step, n):
    return [i * step for i in range(1, n + 1)]

def lcs_recursive(x, y, lcs):
    # print(x, y, lcs)
    if len(x) == 0 or len(y) == 0:
        return lcs
    # match occurred, increment lcs
    if x[-1] == y[-1]:
        return lcs_recursive(x[:-1], y[:-1], lcs + 1)
    return max(lcs_recursive(x[:-1], y, 0), lcs_recursive(x, y[:-1], 0))

for str_size in generate_input_sizes(3, 10):
    x = generate_random_string(str_size)
    y = generate_random_string(str_size)
    print("x:   {}\ny:   {}" .format(x, y))
    result = calc_time_elapsed(lcs_recursive, [x, y, 0])
    print("lcs: {}\ntime elapsed: {:.3f} sn". format(result[0], result[1]))
    print("-" * 15)


"""
Question: If you were to show the resulting 
substring (not just the strength), how would 
you solve this problem?

Answer: I would pass another parameter called 
result, initially empty string, and add matching 
string to it.
"""
