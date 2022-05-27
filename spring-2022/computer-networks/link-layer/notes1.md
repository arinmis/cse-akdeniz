# Link Layer

-   error detection, correction
-   sharing broadcast channel
-   local area networks: Ethernet, VLANs

## 1. Services

-   Pakcet transmission: sender -> packet -> receiver
-   Packets: (header + body)
-   Bit stream -> digital signal -> analog signal

Link layer implemented in _adapter_

-   Ethernet card or chip

### Terminology

-   host and routers: _nodes_
-   _Links_ connects adjacent nodes along
    -   wired links
    -   wireless links
    -   LANs
-   Layer-3 packet: _frame_, encapsulates datagram(network layer)

### Framing, link access

    - encapsutales datagram into frame, adding header, trailer
    - Channel access if shared medium
    - _MAC_ addresses used in frame headers to identify source and dest
    - _Reliable delivery between adjacenet nodes_

### Encoding

-   keep reciver sync with sender
-   low voltage 0, high voltage 1

1. Manchester Encoding
    - Uses transition instead of time
        - 0 = low to high transition
        - 1 = high to low transition

### Implementation

    - Link layer implemented on _Network Interface Card_
        * Ethernet card, 802.11
        * implements link and physical layer

## 2. Error Detection

    - Parity checking
    - Hamming Distance
        * Num. of different bit position., D
        * D - 1 bit errors can be detected.
        * (D - 1) / 2 errors can be corrected
     - Cyclic Redundancy Codes
        * Can detect error with small num of redundant bit.
        * Can be implemented very efficiently in hardware, like CRC-32: Ethernet
