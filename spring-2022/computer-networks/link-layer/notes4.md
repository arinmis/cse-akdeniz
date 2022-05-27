#### Switches

-   Store and forward Ethernet frames
-   Examines incoming frames MAC address, selectively forward to destination.
-   Tranparent \* host are unaware of existence
    _NOTE:_ Full duplex, two way communication
-   Switch forwarding table

    -   it is kind of self learning, it stores MAC addresses and interfaces from frames.

    *   if switch doesn't know target frame interface, it forward this package to allavaliable interfaces except sender.
    *   Only receiver use frames, other drops the frame.

-   Switches vs. Routers
    -   routers network layer devices
    -   switches link layer devices
    -   Both have forwarding table
        -   router compute tables using routing algorithm.
        -   switches learn forwarding table using flooding, learning, MAC addresses.

#### VLANs(Virtual LANs)

-   All layer-2 broadcast traffic must cross entire LAN.

    -   issiues: security/privacy, efficiency

-   Port-based VLAN
    -   Single physical switch operates as multiple switches.
        -   allow traffic isolation
        -   dynamic membership
        -   forwarding done via routing
        -   turnk port carries frames between VLANS defined over multiple physical switches.
