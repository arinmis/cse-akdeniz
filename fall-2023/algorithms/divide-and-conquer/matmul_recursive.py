# multiply square matrixes
def matmul(A, B):
    n = len(A)
    C = [[0] * n for i in range(10)]
    if n == 1:
        C[0][0] = A[0][0] * B[0][0]
    else:
        # split A and B
        A11, A12, A21, A22 = split(A)
        B11, B12, B21, B22 = split(B)

        # partial multiplication 
        C11 = matrix_sum(matmul(A11, B11), matmul(A12, B21))
        C12 = matrix_sum(matmul(A11, B12), matmul(A12, B22))
        C21 = matrix_sum(matmul(A21, B11), matmul(A22, B21))
        C22 = matrix_sum(matmul(A21, B12), matmul(A22, B22))
        print(C11, C12, C21, C21)
    return C



def split(m):
    n = len(m)
    return ([row[:n//2] for row in m[:n//2]],
           [row[n//2:] for row in m[:n//2]],
           [row[:n//2] for row in m[n//2:]],
           [row[n//2:] for row in m[n//2:]])

# performs addition
def matrix_sum(A, B):
    return [[A[i][j] + B[i][j] for j in range(len(A))] for i in range(len(A))]

A = [[1, 2, 3, 4],
     [5, 6, 7, 8],
     [9, 10, 11, 12],
     [13, 14, 15, 16]]


B = [[1, 2, 3, 4],
     [5, 6, 7, 8],
     [9, 10, 11, 12],
     [13, 14, 15, 16]]

print(matrix_sum(A, B))
print("{}\n{}" .format(A, B))
matmul(A, B)

# print(matmul(A, B))
# print(split(A))
