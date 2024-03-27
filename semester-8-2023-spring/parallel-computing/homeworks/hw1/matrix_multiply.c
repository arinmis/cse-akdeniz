#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

void transposeMatrix(int n, int **b, int **b_trans) {
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            b_trans[j][i] = b[i][j];
        }
    }
}

void matrixMultiplyOptimized(int n, int **a, int **b_trans, int **mul) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            mul[i][j] = 0;
            for (int k = 0; k < n; k++) {
                mul[i][j] += a[i][k] * b_trans[j][k]; // Optimized access
            }
        }
    }
}

void matrixMultiplyTraditional(int n, int **a, int **b, int **mul) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            mul[i][j] = 0;
            for (int k = 0; k < n; k++) {
                mul[i][j] += a[i][k] * b[k][j]; // Traditional access
            }
        }
    }
}

int** allocateMatrix(int n) {
    int** matrix = (int**)malloc(n * sizeof(int*));
    for (int i = 0; i < n; i++) {
        matrix[i] = (int*)malloc(n * sizeof(int));
    }
    return matrix;
}

void freeMatrix(int **matrix, int n) {
    for (int i = 0; i < n; i++) {
        free(matrix[i]);
    }
    free(matrix);
}

int main(int argc, char *argv[]) {
    if (argc < 3) {
        printf("Usage: %s <matrix_dimension> <mode>\n", argv[0]);
        printf("Modes:\n traditional\n optimized\n");
        return 1;
    }

    int n = atoi(argv[1]);
    char* mode = argv[2];

    int **a = allocateMatrix(n);
    int **b = allocateMatrix(n);
    int **mul = allocateMatrix(n);
    int **b_trans = NULL;

    // Initialize matrices a and b with values for testing
    // This initialization part is omitted for brevity

    clock_t start, end;
    double cpu_time_used;

    if (strcmp(mode, "optimized") == 0) {
        b_trans = allocateMatrix(n);
        transposeMatrix(n, b, b_trans);
        start = clock();
        matrixMultiplyOptimized(n, a, b_trans, mul);
        end = clock();
    } else if (strcmp(mode, "traditional") == 0) {
        start = clock();
        matrixMultiplyTraditional(n, a, b, mul);
        end = clock();
    } else {
        printf("Invalid mode specified. Use 'traditional' or 'optimized'.\n");
        return 1;
    }

    cpu_time_used = ((double) (end - start)) / CLOCKS_PER_SEC;
    printf("Time taken: %.2f seconds\n", cpu_time_used);

    // Cleanup
    freeMatrix(a, n);
    freeMatrix(b, n);
    freeMatrix(mul, n);
    if (b_trans != NULL) {
        freeMatrix(b_trans, n);
    }

    return 0;
}
