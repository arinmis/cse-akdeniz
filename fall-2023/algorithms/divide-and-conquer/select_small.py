def h_partition(arr, low, high):
    pivot = arr[low]
    left = low - 1
    right = high + 1

    while True:
        # Increment the left index until an element greater than the pivot is found
        left += 1
        while left < high and arr[left] < pivot:
            left += 1

        # Decrement the right index until an element less than the pivot is found
        right -= 1
        while right > low and arr[right] > pivot:
            right -= 1

        # If the indices have crossed, return the right index
        if left >= right:
            return right

        # Swap elements at left and right indices
        arr[left], arr[right] = arr[right], arr[left]

def select_small(A, i, l, r):
    q = h_partition(A, l, r)
    if l == r:
        return l
    if i == q:
        return i
    # look right
    elif i < q:
        return select_small(A, i, l, q) 
    return select_small(A, i, q + 1, r) 

A = [6, 10, 13, 5, 8, 3, 2, 11]
print(h_partition(A, 0, len(A) - 1))
print(A)
