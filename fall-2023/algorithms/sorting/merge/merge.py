def merge(A, p, q, r): 
    L = A[p:q] + [float('inf')]
    R = A[q:r] + [float('inf')]
    i = 0
    j = 0
    for k in range(p, r): 
        # print(k)
        if L[i] < R[j]:
            A[k] = L[i]
            i += 1
        else: 
            A[k] = R[j]
            j += 1


def merge_sort(A, p, r):
    if r - p > 1:
        q = (p + r) // 2
        merge_sort(A, p, q)
        merge_sort(A, q, r)
        merge(A, p, q, r)



# sorted up to j
array = [-4, 1, 2, 5, 12, -3, 8, 10]

# array = [4, 2, 3, 1]
print(array)
merge_sort(array, 0, len(array))
print(array)

