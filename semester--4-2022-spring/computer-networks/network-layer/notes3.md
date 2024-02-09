## 4 IP: Internet Protocol

-   Best Effort
-   Scale very well
-   Not feasible or hard

    -   Latency or bandwidth guarantees

-   Every network has own Maximum Transmission Unit

### IP fragmentation, reassembly

-   Cut big datagram into smaller pieces.
-   Receiver will be resemble those smaller packages.
-   If encounters problem, ICMP message will be returned
    -   "Destination unreachable: Fragmentation needed"

### IP Address Structure

[class bits | Network ID | Host ID]

-   Class A -> [ 0 | 8 bit | 24 bit]
-   Class B -> [ 0 | 16 bit | 16 bit]
-   Class C -> [ 0 | 24 bit | 8 bit]

### Subnet Addressing

[Network ID | Subnet | Host ID]

-   Need for simple way to partition large network caused to create it.
