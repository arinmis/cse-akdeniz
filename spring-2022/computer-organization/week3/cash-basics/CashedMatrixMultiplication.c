#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

int main(int argc,char *argv[]){
    struct timeval s,e;
    int **a,**b,**c;
    int i,j;
    
    // dimensions: n x m
    int row=atoi(argv[1]);
    int col=atoi(argv[1]);
    
    // allocate memory for matrix row
    a=(int**)malloc(row*sizeof(int *));
    b=(int**)malloc(row*sizeof(int *));
    c=(int**)malloc(row*sizeof(int *));
    gettimeofday(&s,NULL);

    // initialize matrix with random numbers
    for (i=0;i<row;i++){
        a[i]=(int *)malloc(col*sizeof(int));
        b[i]=(int *)malloc(col*sizeof(int));
        c[i]=(int *)malloc(col*sizeof(int));
        for (j=0;j<col;j++){
            b[i][j]=rand();
            c[i][j]=rand();
        }
    }

    gettimeofday(&e,NULL);
    printf("Init time: %f\n",(float)((e.tv_sec-s.tv_sec)*1000000+(e.tv_usec-s.tv_usec))/1000000.0);

    gettimeofday(&s,NULL);
    // multiply matrix
    // first row by column 
    for (i=0;i<row;i++){
        for (j=0;j<col;j++){
            a[i][j]=b[i][j]+c[i][j];
        }
    }

    gettimeofday(&e,NULL);
    printf("Exec time: %f\n",(float)((e.tv_sec-s.tv_sec)*1000000+(e.tv_usec-s.tv_usec))/1000000.0);
    return(0);
}
