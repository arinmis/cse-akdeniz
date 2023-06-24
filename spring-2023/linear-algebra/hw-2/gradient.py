import numpy as np

def gradient_descent(A, b, alpha, epsilon):
    x = np.random.rand(A.shape[1])
    grad_norm = np.linalg.norm(2 * A.T @ (A @ x - b))
    
    while grad_norm >= epsilon:
        x -= alpha * 2 * A.T @ (A @ x - b)
        grad_norm = np.linalg.norm(2 * A.T @ (A @ x - b))
    
    return x

x = np.array([[1., 1.], [1.5, 1.], [1.9, 1.], [2.3, 1.], [2.6, 1.], [3., 1.]])
y = np.array([1., 2., 1., 5., 4.5, 2])

alpha=0.001
epsilon=0.005
beta = gradient_descent(x, y, alpha, epsilon)

print(f"The least squares regression line is: y = {beta[0]:0.4f}x + {beta[1]:0.4f}")
