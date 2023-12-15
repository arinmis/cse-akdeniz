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

def generate_input_sizes(step, n):
    return [i * step for i in range(1, n + 1)]

def cut(n, prices):
    if n == 0:
        print()
        return 0 
    calculated_prices = []
    valid_cuts = list(filter(lambda x : x < n, range(len(prices))))
    for i in range(len(valid_cuts)):
        calculated_prices.append(prices[i] + cut(n - i - 1, prices))
    return max(calculated_prices)


prices = [1, 5, 8, 9, 10, 17, 17, 20, 24, 30]
"""
for n in generate_input_sizes(5, 100):
    result = calc_time_elapsed(cut, [n, prices])
    print("n: {}" .format(n))
    print("max price: {}\ntime elapsed: {:.3f} sn". format(result[0], result[1]))
    print("-" * 15)
"""

print("result: ", cut(4, prices))


"""
Question: If you were to show which pieces 
you chose in the algorithm how would you do it?

Answer: I would also keep track of cut pair in 
dictionary and add append new pieces to into it 
{
    price: 30, 
    pieces: [10]
}
"""

