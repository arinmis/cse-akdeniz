### Multiple Access: How to share wire

-   How do you prevent collision?

    -   Explicit coordiantion
    -   Random access medium

-   Ideal Multiple Access Protocol
    1. Only one node can send at rate R
    2. M node can send at range R/M
    3. Full decentralized
        - No node can coordinate transmissions
        - No synchronization of clock, slots
    4. Simple

### MAC protocols

-   Channel Partitioning
    -   Not efficient
-   Random Access
    -   Most suitable solution

#### FDMA

    * Channel spectrum divided into frequency bands.
    * Unusued Transmission time in frequency bands go idle.

#### Code Division (CDMA)

    * Users utilize different coding, same freq. the same time, no confusions occur.

#### Random Access Protocols

-   When node has packet to send

    -   Transmit at full channel data rate R.
    -   No a priori cordination among nodes.

-   Two or more transmission creates _collision_
-   Random Acces MAC Protocol specifies:
    -   How to detect collision
    -   How to recover from collisions
