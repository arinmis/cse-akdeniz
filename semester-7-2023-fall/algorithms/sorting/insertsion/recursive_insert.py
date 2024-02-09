def insertion_sort(A, p):
    if p > len(A) - 1:
        return
    key = A[p]
    i = p
    while key < A[i - 1] and i > 0:
        A[i] = A[i - 1]
        i -= 1
    A[i] = key
    insertion_sort(A, p + 1)


array = [3, 5, 2, 1, 6]
insertion_sort(array, 0)
print(array)
