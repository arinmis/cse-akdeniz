import numpy as np
import argparse
import sys

def generate_and_save_matrix(filename, size):
    # Create a matrix of given size with random floats
    matrix = np.random.rand(size, size)
    # Save the matrix to a binary file
    matrix.tofile(filename)

def print_matrix(filename, size):
    # Load the matrix from a binary file
    try:
        matrix = np.fromfile(filename, dtype=np.float64).reshape(size, size)
        print("Matrix content:")
        print(matrix)
    except ValueError as e:
        print(f"Error loading matrix: {e}")

def main():
    parser = argparse.ArgumentParser(description='Generate or print matrices.')
    parser.add_argument('-s', '--size', type=int, help='Size of the matrix to generate')
    parser.add_argument('-f', '--file', type=str, help='File name of the matrix to print')
    args = parser.parse_args()
    if args.size and args.file:
        print("Generating matrix...")
        generate_and_save_matrix(args.file, args.size)
        print(f"Matrix of size {args.size}x{args.size} has been generated and saved as {args.file}")
    elif args.file:
        # We need size to reshape the matrix for printing, ask for it if only file is provided
        try:
            size = int(input("Please enter the size of the matrix to reshape correctly: "))
            print_matrix(args.file, size)
        except ValueError:
            print("Invalid matrix size entered.")
    else:
        print("No valid operation specified. Use --help for usage information.")

if __name__ == "__main__":
    main()
