import pandas as pd
import matplotlib.pyplot as plt

# Load the results
df = pd.read_csv('matrix_multiplication_results.txt')

# Plotting
for method in df['Method'].unique():
    subset = df[df['Method'] == method]
    plt.plot(subset['Matrix Size'], subset['Execution Time'], label=method)

plt.xlabel('Matrix Size')
plt.ylabel('Execution Time (seconds)')
plt.title('Matrix Multiplication Execution Time by Method and Optimization')
plt.legend()
plt.xscale('log', basex=2)  # Assuming you want a logarithmic scale for clarity
plt.yscale('log', basey=10)
plt.grid(True, which="both", ls="--")
plt.savefig('matrix_multiplication_performance.png')
plt.show()
