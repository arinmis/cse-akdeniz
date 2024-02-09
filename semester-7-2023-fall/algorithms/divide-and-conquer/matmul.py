# multiply square matrixes
def matmul(A, B, n):
    c = []
    for i in range(n):
        row = []
        for j in range(n):
            cij = 0 
            for k in range(n):
                cij += A[i][k] * B[k][j] 
            row.append(cij)
        c.append(row)
    return c

A = [[1, 2],
     [1, 2]]
B = [[1, 2], 
     [1, 2]]
print(matmul(A, B, 2))

