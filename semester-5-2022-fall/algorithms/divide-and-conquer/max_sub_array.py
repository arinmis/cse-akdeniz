def find_max_profit(arr):
    profit = arr[1] - arr[0]
    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            new_profit = arr[j] - arr[i]
            profit = max(profit, new_profit)
    return profit


arr = [10, 11, 7, 10, 6] 
max_profit = find_max_profit(arr)
print(max_profit)
