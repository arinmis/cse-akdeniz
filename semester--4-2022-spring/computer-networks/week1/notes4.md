### Packets loss and delay

-   total delay = dProcesssing + dQueue + dTransmission + dPropagation.
    -   _dProcesssing_: reading packets header and determining where the packets directt
-   Transmission takes more time than propagation.

### Packet Loss

-   If buffer of the router is full, new arrived packet will be lost.

### Throughput

-   rate (bits/time) at which bits transferred between sender/receiver

## Protocol 'layers'

-   Networks are complex with man 'pieces'
    -   host
    -   routers
    -   link of various media
    -   applications
    -   protocols
    -   hardware, software
-   Layered desing organize network

### Why Layering

-   It is easy to reference
-   Modularization eases maintenance, updating of system
    -   Each layer is independent
