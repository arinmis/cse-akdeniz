#include <pthread.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_SIZE = 1000

int mydata[MAX_SIZE];

struct  param {
    int n;
    int p;
};


typedef struct param myparam;

// Thread function to execute.
void* myThreadFun(void* param) {
    myparam val = *(myparam *)param;
    printf("Thread Function, n:%d, p:%d\n", val.n, val.p);
    pthread_exit(0);
    return NULL;
}



int main() {
    for (int i = 0; i < MAX_SIZE; i++) {}
        mydata[i] = i;


    myparam x, y;

    x.n = MAX_SIZE;
    x.p = 1;

    x.n = MAX_SIZE;
    x.p = 2;

    pthread_t t1;
    pthread_t t2;

    int a = 5;
    int b = 8;

    pthread_create(&t1, NULL, myThreadFun, &a);
    pthread_create(&t2, NULL, myThreadFun, &b);


    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}
