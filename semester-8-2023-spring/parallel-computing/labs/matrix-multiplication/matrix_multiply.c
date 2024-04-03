#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <pthread.h>

typedef struct {
    int row;
    int col;
    int n;
    int **A;
    int **B;
    int **Result;
} WorkerArgs;

void *multiplyRow(void *args) {
    WorkerArgs *work = (WorkerArgs *)args;
    for (int j = 0; j < work->n; ++j) {
        work->Result[work->row][j] = 0;
        for (int k = 0; k < work->n; ++k) {
            work->Result[work->row][j] += work->A[work->row][k] * work->B[k][j];
        }
    }
    return NULL;
}

int **allocateMatrix(int n) {
    int **matrix = (int **)malloc(n * sizeof(int *));
    for (int i = 0; i < n; ++i) {
        matrix[i] = (int *)malloc(n * sizeof(int));
        for (int j = 0; j < n; ++j) {
            matrix[i][j] = rand() % 10;  // Initialize with random values
        }
    }
    return matrix;
}

void freeMatrix(int **matrix, int n) {
    for (int i = 0; i < n; ++i) {
        free(matrix[i]);
    }
    free(matrix);
}

void parallelMatrixMultiply(int n, int **A, int **B, int **Result, int numThreads) {
    pthread_t threads[numThreads];
    WorkerArgs args[numThreads];

    for (int i = 0; i < numThreads; ++i) {
        args[i].row = i * (n / numThreads);  // This assumes a perfect division
        args[i].n = n;
        args[i].A = A;
        args[i].B = B;
        args[i].Result = Result;
        if (pthread_create(&threads[i], NULL, multiplyRow, (void *)&args[i])) {
            printf("Could not create thread %d\n", i);
            exit(-1);
        }
    }

    for (int i = 0; i < numThreads; ++i) {
        pthread_join(threads[i], NULL);
    }
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <matrix_size> <num_threads>\n", argv[0]);
        return 1;
    }

    int n = atoi(argv[1]);
    int numThreads = atoi(argv[2]);
    int seed = 523423; //atoi(argv[3]);
    srand(seed);

    int **A = allocateMatrix(n);
    int **B = allocateMatrix(n);
    int **Result = allocateMatrix(n);  // No need to fill result matrix with data

    clock_t start = clock();
    parallelMatrixMultiply(n, A, B, Result, numThreads);
    clock_t end = clock();

    double cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("Time taken: %.2f seconds\n", cpu_time_used);

    // Free allocated memory
    freeMatrix(A, n);
    freeMatrix(B, n);
    freeMatrix(Result, n);

    return 0;
}
