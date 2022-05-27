# Network Layer

-   Network layer service models
-   Forwarding versus routing
-   how a router works
-   broadcast, multicast

## 1. Introduction

-   Encapsulates _segment_ into _datagrams_
-   Router examines IP datagrams passing through it.

### Forwarding vs. Routing

-   **Forwarding**: move packets from router's input to appropriate router output
-   **Routing**: Determine route taken by packets from source to dest.

### Connection Setup

-   Network: between two hosts
-   Transport: between two processes

### Service Model

-   IP: package-switching,
-   Internet
    -   best effort
    -   no bandwith guarantees
    -   no loss, order or timing guarantees
    -   no congestion guarantees

### Circuit Versus Packet Switching

| Circuit Switching              | Packet Switching                         |
| ------------------------------ | ---------------------------------------- |
| Fast                           | slow                                     |
| Inefficient for bursty data    | Allow multiplexing                       |
| pridictable performance        | No performans guarantees                 |
| requires circuit establishment | Data can be sent without signaling delay |

### Virtual Circuits

Path through the network is set up when the VC is established

-   Implementation of circuit swithing up on internet(packet swithing infrastructure)
-   QoS is hard in Packet Switching

#### ATM(Asynchronous Transform Mode)

-   Used before IP
-   Virtual Circuit

#### VC implementation
VC routers maintain connection state information

1. path from source to dest.
2. VC numbers
3. entries in forwarding tables


