#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

void load_matrix_segment(const char* filename, double* matrix_segment, int n, int local_rows, int rank) {
    FILE* file = fopen(filename, "rb");
    if (!file) {
        fprintf(stderr, "Error opening file %s at process %d\n", filename, rank);
        MPI_Abort(MPI_COMM_WORLD, EXIT_FAILURE);
    }

    // Calculate the correct offset for each process to read its part of the matrix
    long offset = rank * local_rows * n * sizeof(double);
    fseek(file, offset, SEEK_SET);
    if (fread(matrix_segment, sizeof(double), local_rows * n, file) != local_rows * n) {
        fprintf(stderr, "Failed to read the required amount of data from %s at process %d\n", filename, rank);
        fclose(file);
        MPI_Abort(MPI_COMM_WORLD, EXIT_FAILURE);
    }
    fclose(file);
}

// Only root process needs to load full matrix B
void load_full_matrix(const char* filename, double* matrix, int n) {
    FILE* file = fopen(filename, "rb");
    if (!file) {
        fprintf(stderr, "Error opening file %s\n", filename);
        MPI_Abort(MPI_COMM_WORLD, EXIT_FAILURE);
    }
    if (fread(matrix, sizeof(double), n * n, file) != n * n) {
        fprintf(stderr, "Failed to read the entire matrix from %s\n", filename);
        fclose(file);
        MPI_Abort(MPI_COMM_WORLD, EXIT_FAILURE);
    }
    fclose(file);
}

void multiply_matrices(const double* A, const double* B, double* C, int n, int rows) {
    for (int i = 0; i < rows; i++) {
        for (int k = 0; k < n; k++) {
            double r = A[i * n + k];
            for (int j = 0; j < n; j++) {
                C[i * n + j] += r * B[k * n + j];
            }
        }
    }
}

int main(int argc, char* argv[]) {
    MPI_Init(&argc, &argv);
    int rank, world_size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &world_size);

    if (argc != 4) {
        fprintf(stderr, "Usage: %s <matrix_size> <matrixA_file> <matrixB_file>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    int n = atoi(argv[1]);
    if (n % world_size != 0) {
        if (rank == 0) {
            fprintf(stderr, "Matrix size %d cannot be evenly distributed among %d processes.\n", n, world_size);
        }
        MPI_Finalize();
        return EXIT_FAILURE;
    }

    int local_rows = n / world_size;
    double *A = (double *)malloc(n * local_rows * sizeof(double));
    double *B = (double *)malloc(n * n * sizeof(double));
    double *C = (double *)malloc(n * local_rows * sizeof(double));
    double *C_final = (rank == 0) ? (double *)malloc(n * n * sizeof(double)) : NULL;

    load_matrix_segment(argv[2], A, n, local_rows, rank);
    if (rank == 0) {
        load_full_matrix(argv[3], B, n);
    }

    // Ensure B is fully loaded before broadcasting
    MPI_Barrier(MPI_COMM_WORLD); // Optional: ensures load is complete if needed
    MPI_Bcast(B, n * n, MPI_DOUBLE, 0, MPI_COMM_WORLD);

    double start_time = MPI_Wtime();
    multiply_matrices(A, B, C, n, local_rows);
    double end_time = MPI_Wtime();

    MPI_Gather(C, n * local_rows, MPI_DOUBLE, C_final, n * local_rows, MPI_DOUBLE, 0, MPI_COMM_WORLD);

    if (rank == 0) {
        printf("Total computation time: %f seconds\n", end_time - start_time);
        free(C_final);
    }

    free(A);
    free(B);
    free(C);

    MPI_Finalize();
    return EXIT_SUCCESS;
}
