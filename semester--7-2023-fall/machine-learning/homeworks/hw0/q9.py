import numpy as np


A = np.array([[0, 2, 4], [2, 4, 2], [3, 3, 1]])
b = np.array([[-2], [-2], [-4]])
c = np.array([[1], [1], [1]])

# a. inverse a matrix
A_inv = np.linalg.inv(A)
print("inverse a matrix:\n", A_inv)

# b 
# A_inv * b
print("\nA_inv * b:\n", np.matmul(A_inv, b))

# A * c
print("\nA * c:\n", np.matmul(A, c))

