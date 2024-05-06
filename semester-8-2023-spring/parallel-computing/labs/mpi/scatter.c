#include <mpi.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char** argv) {
    int N = atoi(argv[1]);
    int numprocs, rank;

    MPI_Init(&argc, &argv);
    MPI_Comm_size(MPI_COMM_WORLD, &numprocs);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    // Check if N is divisible by numprocs
    if (N % numprocs != 0) {
        if (rank == 0) {
            fprintf(stderr, "Array size %d is not divisible by number of processors %d\n", N, numprocs);
        }
        MPI_Finalize();
        return 1;
    }

    int n_per_proc = N / numprocs;
    int *global_data = NULL;
    int *local_data = malloc(n_per_proc * sizeof(int));

    // Initialize array on root process
    if (rank == 0) {
        global_data = malloc(N * sizeof(int));
        for (int i = 0; i < N; i++) {
            global_data[i] = i + 1;
        }
    }

    // Scatter the array to all processors
    MPI_Scatter(global_data, n_per_proc, MPI_INT, local_data, n_per_proc, MPI_INT, 0, MPI_COMM_WORLD);

    // Example: Each processor prints their received segment
    printf("\nProcess %d received elements: \n", rank);
    for (int i = 0; i < n_per_proc; i++) {
        printf("%d ", local_data[i]);
    }
    printf("\n");

    // Cleanup
    if (rank == 0) {
        free(global_data);
    }
    free(local_data);

    MPI_Finalize();
    return 0;
}
