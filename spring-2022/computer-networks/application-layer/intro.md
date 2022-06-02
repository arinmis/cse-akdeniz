# Application Layer

## Protocols
- HTTP
- SMTP, IMAP
- DNS
- Video stramin systems, CDNs

## Progmmaing Network Application
- Socket API


## Way to Interact Computers
1. Client-server model
- Server
    *  Always-on host
    * Permenent IP address
- Client 
    * Communicate with server
    * Not communicate directly with each other
    * Examples: HTTP, IMAP, FTP
2. P2P model
- No always-on server
- Example: file sharing

## Processes Communicating
- Process is execution version of program
- Program running within a host
- Within same host: _inter-process communication_
- Different hosts: _messages_ 
Client process initiates communitcation, server process waits to be contacted.

### Sockets
Process sends/receives messages to/from its socket

""""
application layer
------socket------
transport layer
""""
Procesess need _IP_ and _port number_ in order to communicate.
- Example: port 80 connects you to web server

- An application-layer protocol defines:
    * types of messages exchanged
    * message syntax
    * message semantics
    * rules
- 2 Types of protocols:
    * open protocols: HTTP, SMTP
    * Skype, Zoom

What does transport service does an app need?
- Data integrity
- Timing 
- Throughput
- Security

- Transport layer offers 2 services:
1. TCP
    * Reliable transport 
    * Flow control
    * Congestion control
    * connection-oriented
    * does not provide: timing, minimum throughput guarantee, security
2. UDP
    * unreliable data transfer
    * does not provide: reliability, flow control, congestion control, timing, throughput guarantee, security or conncetion setup 
