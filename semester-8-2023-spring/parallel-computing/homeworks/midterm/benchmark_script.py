import subprocess
import matplotlib.pyplot as plt
import argparse

def run_mpi_command(matrix_size, np):
    # Prepare the command
    command = f"mpirun --oversubscribe -np {np} ./main {matrix_size} matrixA.bin matrixB.bin"
    print(command)
    # Execute the command and capture the output
    result = subprocess.run(command, shell=True, text=True, capture_output=True)
    # Parse the output to find the computation time
    output = result.stdout
    print(output)
    # We assume that the last line of the output contains the computation time
    try:
        time = float(output.strip())  # adjust this based on your output format
        print(f"Output for matrix size {matrix_size}x{matrix_size} with {np} processes: {time} seconds")
    except Exception as e:
        print(f"Error processing output for np={np}: {e}")
        time = None
    return time

def main(args):
    # Extract matrix size and process counts from the arguments
    matrix_size = args.size
    process_counts = args.processes

    times = []

    # Run the MPI command for each process count
    for np in process_counts:
        time = run_mpi_command(matrix_size, np)
        if time is not None:
            times.append(time)
        else:
            times.append(float('nan'))  # Append NaN if there was an error

    # Plotting
    plt.figure(figsize=(10, 5))
    plt.plot(process_counts, times, marker='o')
    plt.title(f'MPI Matrix Multiplication Computation Time vs Number of Processes for {matrix_size}x{matrix_size} Matrix')
    plt.xlabel('Number of MPI Processes (-np)')
    plt.ylabel('Computation Time (seconds)')
    plt.grid(True)
    plt.xticks(process_counts)  # Ensure all process counts are labeled
    plt.show()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Benchmark MPI matrix multiplication.")
    parser.add_argument('-s', '--size', type=int, required=True, help='Size of the matrix')
    parser.add_argument('-p', '--processes', type=int, nargs='+', required=True, help='List of number of processes to benchmark')
    args = parser.parse_args()
    main(args)
