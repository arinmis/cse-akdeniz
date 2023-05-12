#### Datagram Networks

-   No call setup at network layer
-   routers: no state about end-to-end connections
    -   no network-level concept _connection_
-   packets are forwarding using destination host addresses

#### Forwarding Table

-   Destination Address Ranges are mapped to Link Interfaces

-   Longest prefix matching
    -   use longest address prefix that matches destination address from from forwarding table.

#### Datagram or VC network

-   Internet (datagram): simple inside network, complexity at _edge_

    -   data exchange among computers
    -   many link types
    -   _smart_ end system

-   ATM(VC): complexity inside network
    -   evolved from telephony
    -   need for guranteed service
    -   _dumb_ end systems

## 3. Inside a router

Two key router functions:

1. run routing algorigthms/protocols(RIP, OSPF, BGP)
2. forwarding datagrams from incoming to outgoing link

Router can buffer packets

```
RTT.C / sqrt(N)
```

where RTT is 250ms, C is capacity and N is flow
