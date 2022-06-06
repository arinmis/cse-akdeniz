# HTTP

-   Client server model implementation
-   Request responce model
-   HTTP opens TCP connection with using port 80
-   HTTP is stateless: server maintains no information about past client request.
-   Two types of HTTP connection:

    -   Non-persistent HTTP: support single object sent
    -   Persistent HTTP: support multiple object sent

-   _RTT(definition):_ Time for a small packet to travel from client to server and back.

## Non-persistent HTTP

Consist of two step:

1. Initiate TCP connection
2. Request file
3. Kill connection
   Total time: 2RTT + file transmission time

## Persistent HTTP 1.1

1. Initiate TCP connection
2. Request file
3. Go to step 2 to fetch new object
4. Kill conncetion if it is not needed
   Total time: 2RTT + (Number of file) \* file transmission time

It reduceses number of RTT 1 for all request other than the first one.

## HTTP messages

### Request methods:

Request line

```
GET /index.html HTTP/1.1\r\n
```

    1. POST
        - Send data inside the requst body
    2. GET
        - Send data to server inside url field
    3. HEAD
        - GET method without responce body.
    4. PUT
        - Upload new file to server

### Response message

Response line

```
HTTP/1.1 200 OK
```

### Maintaining State: Cookies

Web sites use **cookies** to maintain some state between transactions.

1. Server sends cookie in header with response
2. In trailing request, client sends cookie back to server with request.

## Web Caches

-   Proxy server that provides object to client without origin server access needed.
