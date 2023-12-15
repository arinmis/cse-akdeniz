import numpy as np
import matplotlib.pyplot as plt

# Define n as 10000
n = 10000

# Generate n samples of Z_i from standard normal distribution
Z = np.random.randn(n)

# Plot F_n(x) as a step function
plt.step(sorted(Z), np.arange(1, n+1) / float(n))
# Add a title and labels
plt.title("Empirical CDF of Z_i")
plt.xlabel("x")
plt.ylabel("F_n(x)")
# Show the plot
plt.show()
