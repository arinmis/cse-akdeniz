### Main Idea

-   In short fetching data from the CPU cash is much faster than fetching data from the main memory. Imagine that we have two n-by-n matrices and we want to multiply them. Whether you loop through the first row then column

```
for (i=0;i<row;i++){
    for (j=0;j<col;j++){
       a[i][j]=b[i][j]+c[i][j];
    }
}
```

or vice versa

```
for (j=0;j<col;j++){
    for (i=0;i<row;i++){
        a[i][j]=b[i][j]+c[i][j];
    }
}
```

both of them are obviously O(n^2) algorithms but in real-world CPU cashes some sequence of memory locations, multiplying the first row then column will be much faster. Matrix is a two-dimensional array and each row is represented by a one-dimensional array. When CPU executes multiplication first row then column, it cashes row and uses chashed rows data.

-   To measure the performance effect on C, compare two approaches by multiplying 20.000-by-20.000 two matrices.

1. Compile C source codes with GCC:

```
gcc -o fast CashedMatrixMultiplication.c
gcc -o slow NoneCashedMatrixMultiplication.c
```

2. Run the binaries:

```
./fast 20000
```

```
./slow 20000
```

##### Result

-   I have obtained those numbers with the laptop that has Intel Core i5-10210U CPU 1.60GHz with 8GB RAM:

*   _./fast 20000_

```
Init time: 6.976491
Exec time: 1.609989
```

-   _./slow 20000_

```
Init time: 6.963431
Exec time: 36.298052
```
