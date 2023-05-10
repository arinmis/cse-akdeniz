from flask import Flask, jsonify
from google.protobuf.json_format import MessageToDict

import requests
import data_pb2
import data_pb2_grpc
import grpc

print(grpc.__file__)

port =  5000

restServer = Flask(__name__)

@restServer.route('/rest/<n>')
def json(n):
    n = int(n)
    url = "http://localhost:3000/rest"

    i = 1;
    while (i < n): 
        requests.get("{0}/{1}".format(url, i))
        i += 1

    # A GET request to the API
    response = requests.get("{0}/{1}".format(url, i))

    values = response.json()

    # Print the response
    # print("values updated", values)

    return jsonify(values) 



'''
fetch values from gRPC server   
'''
@restServer.route('/grpc/<n>')
def grpcEndpoint(n):
    channel = grpc.insecure_channel('localhost:3001')
    stub = data_pb2_grpc.DataServiceStub(channel)

    request = data_pb2.DataRequest()

    i = 1;
    while i < int(n): 
        request.n = i # set amount
        stub.QueryData(request)
        i += 1

    request.n = i

    response = stub.QueryData(request)
    response_dict = MessageToDict(response)
    return jsonify(response_dict)


if __name__ == '__main__':
    restServer.run(host='0.0.0.0', port=port)
