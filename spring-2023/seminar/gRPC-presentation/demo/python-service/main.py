from flask import Flask, jsonify
import requests

app = Flask(__name__)

@app.route('/json/<n>')
def json(n):
    values = fetchData(int(n))
    return jsonify(values) 


def fetchData(n):
    url = "http://localhost:3000/json"

    i = 1;
    while (i < n): 
        requests.get("{0}/{1}".format(url, i))
        i += 1

    # A GET request to the API
    response = requests.get("{0}/{1}".format(url, i))

    values = response.json()

    # Print the response
    print("values updated", values)

    return values

app.run(host='0.0.0.0', port=5000)
