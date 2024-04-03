#!/bin/bash

# Compile the matrix multiplication program with optimization
gcc -o matrix_multiply matrix_multiply.c -O3

# File to store the results
results_file="matrix_multiplication_results.txt"
echo "Matrix Size, Method, Execution Time" > $results_file

# Array of matrix sizes
declare -a sizes=(512 1024 2048 4096 8192 16384 32768)

# Loop through the array of sizes
for size in "${sizes[@]}"; do
    # Traditional multiplication
    start=$(date +%s.%N)
    ./matrix_multiply $size traditional
    end=$(date +%s.%N)
    runtime=$(echo "$end - $start" | bc)
    echo "${size},Traditional,$runtime" >> $results_file

    # Optimized multiplication
    start=$(date +%s.%N)
    ./matrix_multiply $size optimized
    end=$(date +%s.%N)
    runtime=$(echo "$end - $start" | bc)
    echo "${size},Optimized,$runtime" >> $results_file
done
