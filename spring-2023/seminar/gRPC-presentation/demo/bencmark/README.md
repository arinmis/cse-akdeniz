# Benchmark: REST vs. gRPC
Results of data exchange performance among python and node service.

<div align="center">
    <img src="https://github.com/arinmis/cse-akdeniz/assets/56651041/26dea8ee-28b7-4f64-98b5-93315e76d13b" />
</div>

# To Run

1. make sure Python and Node services are up and running locally.
2. active environment and install dependencies.
```
python -m venv env
source env/bin/active
pip install -r requirements.txt
```
3. run benchmark script and pass command line argument as amount of data point to collect, it will starts from 10 and measures multiplies of tens like: 10, 20, 30...
```
python main.py 100
```
