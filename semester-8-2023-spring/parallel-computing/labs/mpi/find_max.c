#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int main(int argc, char** argv) {
    int N = atoi(argv[1]);
    int numprocs, rank;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if (N % numprocs != 0) {
        if (rank == 0) {
            fprintf(stderr, "The number of elements must be divisible by the number of processors.\n");
        }
        MPI_Finalize();
        return 1;
    }

    int n_per_proc = N / numprocs;
    int *global_data = NULL;
    int *local_data = malloc(n_per_proc * sizeof(int));

    // Initialize the array in the root process
    if (rank == 0) {
        global_data = malloc(N * sizeof(int));
        for (int i = 0; i < N; i++) {
            global_data[i] = i + 1;  // Fill the array with some values
        }
    }

    // Scatter the data from the root process to all processes
    MPI_Scatter(global_data, n_per_proc, MPI_INT, local_data, n_per_proc, MPI_INT, 0, MPI_COMM_WORLD);

    // Each process finds the maximum in their portion of the array
    int local_max = INT_MIN;
    for (int i = 0; i < n_per_proc; i++) {
        if (local_data[i] > local_max) {
            local_max = local_data[i];
        }
    }

    int global_max;
    // Reduce all local maxima to the global maximum at the root process
    MPI_Reduce(&local_max, &global_max, 1, MPI_INT, MPI_MAX, 0, MPI_COMM_WORLD);

    // The root process prints the result
    if (rank == 0) {
        printf("The maximum value is %d\n", global_max);
    }

    // Cleanup
    free(local_data);
    if (rank == 0) {
        free(global_data);
    }

    MPI_Finalize();
    return 0;
}
