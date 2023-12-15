def insertion_sort(A):
    for j in range(1, len(A)):
        key = A[j]
        i = j - 1
        while i >= 0 and A[i] > key:
            A[i + 1] = A[i]
            i -= 1
        A[i + 1] = key


arr = [12, 1, 5, 2, 11]
print("input:  ", arr)
insertion_sort(arr)
print("output: ", arr)
