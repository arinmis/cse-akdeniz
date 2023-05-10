# Benchmark: REST vs. gRPC

# To Run

1. make sure Python and Node serices are up and running locally.
2. active environment and install dependencies.
```
python -m venv env
source env/bin/active
pip install -r requirements.txt
```
3. run benchmark script and pass command line argument as amount of data point to collect, it will starts from 10 and measures multiplies of tens like: 10, 20, 30...
```
python main 100
```
