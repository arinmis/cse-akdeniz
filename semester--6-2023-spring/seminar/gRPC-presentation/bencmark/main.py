import requests
import sys
import matplotlib.pyplot as plt


# bench mark limit
n = int(sys.argv[1])

rest_data = {"x": [], "y": []}
grpc_data = {"x": [], "y": []}

for i in range(10, 10 * (n + 1), 10):
    response_rest = requests.get("http://localhost:5000/rest/{0}". format(i))
    response_grpc = requests.get("http://localhost:5000/grpc/{0}". format(i))


    rest_data["x"].append(i)
    rest_data["y"].append(response_rest.elapsed.total_seconds())
    print("rest", i, response_rest.elapsed.total_seconds())

    grpc_data["x"].append(i)
    grpc_data["y"].append(response_grpc.elapsed.total_seconds())
    print("grpc", i, response_grpc.elapsed.total_seconds())

    print()


print(rest_data)
print(grpc_data)
  
# plot lines
plt.plot(rest_data["x"], rest_data["y"], label = "REST API")
plt.plot(grpc_data["x"], grpc_data["y"], label = "gRPC API")
plt.xlabel("amount of data fetched")
plt.ylabel("time(s)")
plt.legend()
plt.show()






