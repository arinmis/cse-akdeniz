from flask import Flask, jsonify
import requests

app = Flask(__name__)

@app.route('/json')
def index():
# The API endpoint
    url = "http://localhost:3000/json"

    # A GET request to the API
    response = requests.get(url)
    # Print the response
    response_json = response.json()
    print(response_json)

    data = {"hey": 'Web App with Python Flask!'}
    return jsonify(data) 

app.run(host='0.0.0.0', port=5000)
