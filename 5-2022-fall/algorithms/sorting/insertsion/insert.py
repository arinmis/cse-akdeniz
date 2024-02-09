def insertion_sort(A):
    for j in range(1, len(A)):
        key = A[j]
        i = j - 1
        while i >= 0 and A[i] > key:
            A[i + 1] = A[i]
            i -= 1
        A[i + 1] = key

arr = [2, 1, 3, 1, 2]

# arr = [12, 1, 5, 2, 11]
insertion_sort(arr)
print("sorted", arr)
