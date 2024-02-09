def max_sub_array(A):
    max_sum = A[0]
    for i in range(1, len(A)):
        A[i] = max(A[i], A[i] + A[i - 1])
        max_sum = max(max_sum, A[i])  
    return max_sum


A = [13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7]
print(max_sub_array(A))
