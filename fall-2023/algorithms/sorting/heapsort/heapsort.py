def heapify(A, i, n):
    largest = i
    left_index =  2 * i + 1
    right_index =  2 * i + 2
    if left_index <= n and A[left_index] > A[i]:
        largest = 2 * i + 1
    if right_index <= n and A[right_index] > A[largest]:
        largest = 2 * i + 2
    if not largest == i:
        A[i], A[largest] = A[largest], A[i]
        heapify(A, largest, n)

def extract_max(A, n):
    max_value = A[0]
    A[0] = A[n]
    n -= 1
    heapify(A, 0, n)
    return max_value

def build_heap(A, n):
    pass

def heapsort(A, n):
    for i in range(n, 0, -1):
        A[0], A[i] = A[i], A[0]
        heapify(A, 0, i - 1)
        print(i - 1)
        print(A)

A = [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
n = len(A) - 1
print(A)
print(heapsort(A, n))
print(A)

