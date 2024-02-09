from random import randint

def l_partition(A, l, r): 
    pivot = A[r]
    i = l - 1
    for j in range(l + 1, r):
        if A[j] < pivot:
            i += 1
            A[i], A[j] =  A[j], A[i]
    A[i], A[r] =  A[r], A[i]
    return i


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



def quick_sort(A, l, r):
    if l < r:
        q = h_partition(A, l, r)
        quick_sort(A, l, q)
        quick_sort(A, q + 1, r)

# A = [randint(1, 100) for _ in range(10)] 
A = [-3, 5, 1, 6, 7] 
print("unsorted: ", A)
quick_sort(A, 0, len(A) - 1)
print("sorted: ", A)
