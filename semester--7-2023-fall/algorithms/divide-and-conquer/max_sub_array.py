def calc_changes(prices):
    return [prices[i] - prices[i-1] for i in range(1, len(prices))]

def find_max_crossing_subarray(A, low, mid, high):
    left_sum = float('-inf') 
    total = 0
    max_left = mid
    for i in range(mid, low - 1, -1):
        total += A[i]
        if total > left_sum:
            left_sum = total
            max_left = i

    right_sum = float('-inf') 
    total = 0
    max_right = mid + 1
    for i in range(mid + 1, high + 1):
        total += A[i]
        if total > right_sum:
            right_sum = total
            max_right = i
    return (max_left, max_right, left_sum + right_sum)

def find_max_subarray(A, low, high):
    if low == high:
        return (low, high, A[low])
    else:
        mid = (high + low) // 2
        (left_low, left_high, left_sum) = find_max_subarray(A, low, mid)
        (right_low, right_high, right_sum) = find_max_subarray(A, mid + 1, high)
        (cross_low, cross_high, cross_sum) = find_max_crossing_subarray(A, low, mid, high)
        if left_sum >= right_sum and left_sum >= cross_sum:
            return (left_low, left_high, left_sum)
        elif right_sum >= cross_sum:
            return (right_low, right_high, right_sum)
        return (cross_low, cross_high, cross_sum)

prices = [10, 11, 7, 10, 6]
changes = calc_changes(prices)

print(changes)
max_subarray = find_max_subarray(
        changes, 
        0,
        len(changes) - 1)

print(max_subarray)
