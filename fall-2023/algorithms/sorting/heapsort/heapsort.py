def heapify(A, i, n):
    largest = i
    if 2 * i <= n and A[2 * i + 1] > A[i]:
        largest = 2 * i + 1
    if 2 * i + 1 <= n and A[2 * i + 2] > A[largest]:
        largest = 2 * i + 2
    if not largest == i:
        A[i], A[largest] = A[largest], A[i]
        heapify(A, largest, n)

def extract_max(A, n):
    pass

def build_heap(A, n):
    pass

def heapsort(A, n):
    pass

A = [1, 14, 10, 8, 7, 9, 3, 2, 4, 16]
print(A)
heapify(A, 0, len(A) - 2)
print(A)




