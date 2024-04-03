import subprocess
import time
import os
import math
import matplotlib.pyplot as plt

# Constants
NUM_OPERATIONS = 1000000
MAX_THREADS = 64
THREAD_STEP = 1  # Change this if you want to test with different step sizes
MAIN_EXECUTABLE = "./main"

def measure_execution_time(operations, threads):
    start_time = time.time()
    result = subprocess.run([MAIN_EXECUTABLE, str(operations), str(threads)], 
                        stdout=subprocess.PIPE, 
                        text=True) 
    end_time = time.time()
    result = float(result.stdout)
    return end_time - start_time, result

if not os.path.exists(MAIN_EXECUTABLE):
    raise FileNotFoundError(f"The executable {MAIN_EXECUTABLE} does not exist.")

# Main execution
thread_counts = list(range(1, MAX_THREADS + 1, THREAD_STEP))
execution_times = []
calculated_pis = []
errors = []

for threads in thread_counts:
    execution_time, calculated_pi = measure_execution_time(NUM_OPERATIONS, threads)
    execution_times.append(execution_time)
    calculated_pis.append(calculated_pi)
    errors.append(abs(math.pi - calculated_pi))  # Calculate the absolute error
    print(f"Threads: {threads}, Execution Time: {execution_time} seconds, Calculated Pi: {calculated_pi}")

# Plotting Execution Time
plt.figure(figsize=(14, 6))
plt.subplot(1, 2, 1)  # First subplot for execution time
plt.plot(thread_counts, execution_times, marker='o', linestyle='-', color='b')
plt.title('Computation Time vs Number of Threads')
plt.xlabel('Number of Threads')
plt.ylabel('Computation Time (seconds)')
plt.grid(True)
plt.xticks(thread_counts)

# Plotting Error Margin
plt.subplot(1, 2, 2)  # Second subplot for error margin
plt.plot(thread_counts, errors, marker='x', linestyle='--', color='r')
plt.title('Error Margin vs Number of Threads')
plt.xlabel('Number of Threads')
plt.ylabel('Error Margin (absolute error)')
plt.grid(True)
plt.xticks(thread_counts)
plt.tight_layout()
plt.savefig('stats.png', dpi=300)  # Save as PNG with 300 DPI
# plt.show()
