# Instanll Dependencies
```
sudo apt install openmpi-bin
sudo apt install libopenmpi-dev
```

## Compile
```
mpicc main.c -o main
```

## Run
```
mpirun --oversubscribe -np 40 ./main
```
