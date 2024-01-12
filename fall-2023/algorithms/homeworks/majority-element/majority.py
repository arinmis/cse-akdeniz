# T(n) = 2T(n/2) + O(n) = O(n log n)
def majority_element(A, l, r):
    if l == r:
        return A[l]

    mid = (r - l) // 2 + l
    left_majority = majority_element(A, l, mid)
    right_majority = majority_element(A, mid + 1, r)
    
    if is_majority(A, left_majority):
        return left_majority

    if is_majority(A, right_majority):
        return right_majority

    return -1

"""
checks given number majority
runs O(n)
"""
def is_majority(A, x):
    count = 0
    for num in A:
        if num == x:
            count += 1
    return True if count > len(A) / 2 else False

A = [2,2,1, 1, 2]
majority = majority_element(A, 0, len(A) - 1)

print(f"flavors: {A}\nmajority flavor {majority}")
