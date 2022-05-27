# Link Layer

-   About communication between neighbouring deviceses
-   _NOTE:_ One can connect devices without higher level layers like IP(network)
-   Some services:

    -   error detection and correction
    -   multiple access
    -   link layer addressing
    -   local area networks: Ethernet, VLANs

-   From Signal to Packets

```
Pakcet Transmission: *sender* -> #package# -> *Receiver*

Packets:              01001010101010101100101010101010110

Bit Stream:           0    0    1    0    1    1    0   1

Digital Signal:       _----_----_----__----_----_----_

Analog Signal:        ⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝⏜⏝
```

## Implementation

-   Implemented in "adapter"
    -   Ethernet card or chip

## Introduction

-   Data-link layer transforms data from one node to physically adjacent node over a link.
-   hosts and routers: _notes_
-   channels that connect adjacent nodes: _links_
    -   wired links
    -   wireless links
    -   LANs
-   layer-2 packet: _frame_ encapsulates datagram(network layer data)
