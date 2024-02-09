# Import packages
import numpy as np
import matplotlib.pyplot as plt
from scipy.stats import norm

# Set random seed for reproducibility
np.random.seed(42)

# Define parameters
k = 100 # Number of random variables to sum
n = 10000 # Number of samples to generate
x = np.linspace(-3, 3, 100) # Values of x to plot

# Generate samples of Y^(k)
B = np.random.choice([-1, 1], size=(n, k)) # Matrix of -1 and 1 with shape (n, k)
Y = B.sum(axis=1) / np.sqrt(k) # Vector of Y^(k) values with shape (n,)

# Compute empirical CDF of Y^(k)
ecdf = np.array([np.mean(Y <= xi) for xi in x]) # Vector of empirical CDF values with shape (100,)

# Compute true CDF of standard normal distribution
tcdf = norm.cdf(x) # Vector of true CDF values with shape (100,)

# Plot empirical CDF and true CDF
plt.plot(x, ecdf, label='Empirical CDF')
plt.plot(x, tcdf, label='True CDF')
plt.xlabel('x')
plt.ylabel('CDF')
plt.legend()
plt.show()
