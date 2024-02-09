### Multiple Access Protocol

-   Used in WAN, LAN and home connections
-   Kind of link layer routing
-   MAC = (local) scheduling
-   Two types of links:
    -   point-to-point
    -   broadcast(shared wire of medium)
        -   Like ethernet, WiFi, staellite

**Problem:** How to prevent _collision_, talking at the same time.

-   Explicit Coordination: Scheduled Access MACs
-   Randomly Access Medium

#### An ideal multiple access protocol

-   Given: broadcast channel of rate R bps.
-   Desired:
    1. one node can send at rate R.
    2. M node can send R/M
    3. Fully decentralized
    4. Simple

#### MAC protocols: taxonomy

### Channel partitioning

    -   Like TDMA, FDMA, CDMA
    -   allocate piece to node
    -   not efficient

### Random access

    - Protocols:
        * slotted ALOHA
        * ALOHA
        * CSMA, CSMA/CD, CSMA/CA
    -   channel not divided, allow collision
    -   _recover_ from collision

#### Slotted ALOHA

-   All frames same size
-   Time divided into equal size slots.
-   Node start to transmit only slot begin
-   if no collision then send new frame
-   if collision then send frame with prob. p until success.
-   Idle slots can be occur.

#### Pure ALOHA

-   No clock sync
-   Less efficient

#### CSMA (Carrier sense multiple access)

Listen beofre transmit:

-   if channel sensed idle: transmit entire frame
-   else, defer transmission  
    Because of propagation delay, collision might still occur.

#### CSMA/CD

-   Collisions detected within short time
-   collision detection:
    -   easy in wired LANs: measure signal strengths, compare transmitted, received signals
    -   difficult in wireless LANs: received signal strength overwhelmed by local transmission strength
-   Human analogy: the polite conversationalist

#### Ethernet CSMA/CD Algorithm

-   If collision occurs, _binary backoff_ algorithm to wait and then try retransmission.

### Taking Turns

1. Channel partitioning MAC protocols

-   share channel, effiently and fairly at high load.
-   inefficient at low load.

2. Random Access MAC Protocols

-   Efficient at low load
-   High Load: collision overhead

Taking turns takes best of two approach.

#### Polling

-   master node _invites_ slave nodes to transmit in turn.

-   Typically used with _dumb_ slave devices.

#### Token Passing

-   Token passed form one node to next sequentially
