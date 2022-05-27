## Datalink Functions

-   _Encoding_ Change bit stream before transmission
-   _Framing:_ Encapsulate network layer datagram into a bit stream
-   _Error control:_ Detection and Correction
-   _Flow Contro:_
-   _Media access:_ Who will be using the link
-   _Hubbing, Bridging:_ Extend the size of the network

### Framing, Link Access

-   Encapsulate datagram into frame, adding header, trailer
-   Channel access ifshared medium
-   "MAC" addresses used in frame headers to identify source, dest

    -   different from IP address, it runs locally

-   _Framing:_ Defines which bits have which function.

-   _Encoding:_ Converts 0s and 1s to low and high voltages.

### Link Layer Implementation

-   In each host it is implemented with _network interface card_.
    -   Ethernet card, 802.11
    -   Has both Link and Physical layer

### Error Correction

-   Parity Checking
-   Hamming Distance
