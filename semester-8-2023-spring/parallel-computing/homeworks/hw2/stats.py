import subprocess
import time
import os
import matplotlib.pyplot as plt

# Constants
NUM_OPERATIONS = 1000000
MAX_THREADS = 64
THREAD_STEP = 1  # Change this if you want to test with different step sizes
MAIN_EXECUTABLE = "./main"

def measure_execution_time(operations, threads):
    start_time = time.time()
    subprocess.run([MAIN_EXECUTABLE, str(operations), str(threads)])
    end_time = time.time()
    return end_time - start_time

if not os.path.exists(MAIN_EXECUTABLE):
    raise FileNotFoundError(f"The executable {MAIN_EXECUTABLE} does not exist.")

# Main execution
thread_counts = list(range(1, MAX_THREADS + 1, THREAD_STEP))
execution_times = []

for threads in thread_counts:
    execution_time = measure_execution_time(NUM_OPERATIONS, threads)
    execution_times.append(execution_time)
    print(f"Threads: {threads}, Execution Time: {execution_time} seconds")

# Plotting
plt.figure(figsize=(10, 6))
plt.plot(thread_counts, execution_times, marker='o', linestyle='-', color='b')
plt.title('Computation Time vs Number of Threads')
plt.xlabel('Number of Threads')
plt.ylabel('Computation Time (seconds)')
plt.grid(True)
plt.xticks(thread_counts)
plt.tight_layout()
plt.show()
