# Install Dependencies
```
sudo apt install openmpi-bin
sudo apt install libopenmpi-dev
```

## Compile
```
mpicc <scatter>.c -o scatter
```

## Run
```
mpirun --oversubscribe -np 40 ./scatter 1000
```
