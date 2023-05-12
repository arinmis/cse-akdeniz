### Internet

-   Network of networks
-   Protocols: TCP, IP, HTTP, 802.11
-   Internet Standards:

*   RFC
*   IETF

### Protocol

-   Defines the format and the order of messages exchagned between two entities.

### Network Edge

#### Access Networks

-   Physically connects an end system to the first router(edge router).

1. Home Access: DSL, Cable, FTTH, Dial-Up, and Satellite

-   wireless LANs
-   wide-area wireless access

2. Physical Media

-   bit
-   physical link
-   guided and unguided

#### (End systems)Host: sends packets of data

-   client programs and server programs
-   takes application message
-   breaks into chunks, **packets** length L
-   Transmission rate R

*   capacity, aka link bandwidth
    -   packet transmission delay = L / R

#### Network Core

1. Package Switching

-   Brake long messages into smaller chuncks

##### Store-and-forward

-   Routers stores all bits of the package, process the package and then transmits it to the next destination.

##### Queuing Delaya and Packet Loss

-   **Output queue(output buffer)** stores packages that the router is about to send.
-   Queuing delay causes **packet loss**.

##### Forwarding Tables and Routing Protocols

-   Every end system has and IP address.
-   Each router has a _forwarding table_ that maps destination address.
-   Run following command in lunix machine to see visited routers to connect Google

```
traceroute google.com
```

2. Circuit Switching

-   _Reserved_ sources instead of shared.
-   Guarantees constant rate of bandwith.
-   Can be implementing either _frequency-division multiplexing_ or _time-division multiplexing_

##### Package vs. Circuit Switching

-   Internet uses _package swithing_ and makes _best effort_ but does not make any gurantees.
-   Packet swithing is not as efficeint as circuit swithing for real-time application.
-   Circuit swithing is fast but very costly to implement.

3. Network of Networks
- 
