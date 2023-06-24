"""
Mustafa Arinmis
20190808004
abcdefghijk
"""
import numpy as np

# create design matrix
x = np.array([
    [1., 1.], 
    [1.5, 1.], 
    [1.9, 1.],
    [2.3, 1.], 
    [2.6, 1.], 
    [3., 1.]])

y = np.array([1., 2., 1., 5., 4.5, 2]) # dependent variable

q, r = np.linalg.qr(x)
beta = np.linalg.solve(r, q.T @ y)

print(f"The least squares regression line is:  y = {beta[0]:0.4f}x + {beta[1]:0.4f}")
