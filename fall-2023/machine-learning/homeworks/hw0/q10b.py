import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import norm

# Generate n standard normal random variables
n = 10**5
Z = np.random.randn(n)

# Define the range of x values
x = np.linspace(-3, 3, 100)
print(x)

# Calculate the true CDF values
F = norm.cdf(x)

# Calculate the empirical CDF values
Fn = np.array([np.mean(Z <= xi) for xi in x])

# Plot both CDFs
plt.plot(x, F, label='True CDF')
plt.step(x, Fn, label='Empirical CDF')
plt.xlabel('x')
plt.ylabel('CDF')
plt.legend()
plt.show()
