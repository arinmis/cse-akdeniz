# Compile
```
mpicc main.c -Ofast -o main
```

# Run
```
mpirun --oversubscribe -np 8 ./main 5000 matrixA.bin matrixB.bin
```

## Genereate matrices
```
python generate_matrices.py -s 5000 -f matrixA.bin
python generate_matrices.py -s 5000 -f matrixB.bin
```

## Read matrices
```
python generate_matrices.py -f matrixA.bin
```

### Run Benchmark Script
```
python benchmark_script.py --size 50 --processes 1 2 5 10 25
```
