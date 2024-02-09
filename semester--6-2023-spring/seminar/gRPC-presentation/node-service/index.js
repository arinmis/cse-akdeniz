const express = require("express");
const bodyParser = require("body-parser");
const protobuf = require("protobufjs");

const portRest = 3000;
const portGrpc = portRest + 1;

/* gRPC server configs */
const path = require("path");
const grpc = require("@grpc/grpc-js");
const protoLoader = require("@grpc/proto-loader");
const packageDefinition = protoLoader.loadSync(
  path.join(__dirname, "../protos/data.proto"),
  {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true,
  }
);

const dataProto = grpc.loadPackageDefinition(packageDefinition);

const grpcServer = new grpc.Server();

/* REST service configs */
const restServer = express();

// middlewares
restServer.use(bodyParser.json());
restServer.use(bodyParser.urlencoded({ extended: false }));

/* response n amount of value */
restServer.get("/rest/:n", (req, res) => {
  const n = req.params.n;
  data = { values: genDataArray(n) };
  console.log(`REST endpoint has been called with param ${n}`);
  res.json(data);
});

restServer.listen(portRest, () => {
  console.log(`Node REST service is listening on port ${portRest}`);
});

/* gRPC endpoints */
grpcServer.addService(dataProto.DataService.service, {
  QueryData: (call, callback) => {
    const n = Number(call.request.n);
    console.log(`gRPC endpoint has been called with param ${n}`);
    const data = { value: genDataArray(n) };
    callback(null, data);
  },
});

grpcServer.bindAsync(
  `0.0.0.0:${portGrpc}`,
  grpc.ServerCredentials.createInsecure(),
  () => {
    grpcServer.start();
    console.log(`Node gRPC service is listening on port ${portGrpc}`);
  }
);

/* generate random data object */
function generateData() {
  return {
    time: Date.now(),
    value: Math.random() * 100,
    available: Math.random() < 0.5,
  };
}

/* generate array of random data */
function genDataArray(n) {
  const array = [];
  for (let i = 0; i < n; i++) {
    array.push(generateData());
  }
  return array;
}
