#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h> // For min function

#define MAX_THREADS 64

typedef struct {
    int start;
    int end;
    double result;
} ThreadData;

void* compute_pi_segment(void* args) {
    ThreadData* data = (ThreadData*)args;
    double sum = 0.0;
    for (int i = data->start; i < data->end; i++) {
        if (i % 2 == 0) { // even index elements are positive
            sum += 1.0 / (2 * i + 1);
        } else { // odd index elements are negative
            sum -= 1.0 / (2 * i + 1);
        }
    }
    data->result = sum;
    pthread_exit(NULL);
}

int main(int argc, char *argv[]) {
    if (argc != 3) {
        printf("Usage: %s <number of operations> <number of threads>\n", argv[0]);
        return 1;
    }

    int numTerms = atoi(argv[1]);
    int numThreads = atoi(argv[2]);

    // Ensure the number of threads is within the allowed range
    numThreads = numThreads < 1 ? 1 : numThreads;
    numThreads = numThreads > MAX_THREADS ? MAX_THREADS : numThreads;

    pthread_t* threads = malloc(numThreads * sizeof(pthread_t));
    ThreadData* threadData = malloc(numThreads * sizeof(ThreadData));
    int termsPerThread = numTerms / numThreads;
    
    for (int i = 0; i < numThreads; i++) {
        threadData[i].start = i * termsPerThread;
        threadData[i].end = (i + 1) * termsPerThread;
        // Ensure the last thread picks up any remaining terms
        if (i == numThreads - 1) {
            threadData[i].end = numTerms; // Adjust for any remainder
        }
        pthread_create(&threads[i], NULL, compute_pi_segment, (void*)&threadData[i]);
    }

    double pi = 0.0;
    for (int i = 0; i < numThreads; i++) {
        pthread_join(threads[i], NULL);
        pi += threadData[i].result;
    }
    
    pi *= 4.0;
    printf("%.15f\n", pi);

    free(threads);
    free(threadData);

    return 0;
}
