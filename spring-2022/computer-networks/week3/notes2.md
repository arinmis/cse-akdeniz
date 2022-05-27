### MAC addresses and ARP

-   32-bit IP address:

    -   network-layer address for interface
    -   used for layer 3 (network layer) forwarding

-   MAC (or LAN or physical or Ethernet) address.

    -   _locally_ address identifier
    -   48 bit MAC address, example: 1A-2F-BB-76-09-AD

#### LAN addresses and ARP

    - Each adapter on LAN has unique LAN address
    **Note:** Device that is working above the _physical layer_ has to have MAC addresses, like wifi repeater. In general, device that is working on certain layer must implement all the lower networks layer.

##### ARP: learn MAC address

-   How to determine interface's MAC address, knowing its IP address?
-   _ARP Table:_ each IP node on LAN has table.

    -   IP/MAC address mappings for some LAN nodes. `<IP address; MAC address; TTL>`
    -   TTL(Time to Live): time after which mapping will be forgetting

-   A wants to send datagram to B
    1. _broadcasts_ ARP query
        - dest MAC address = FF-FF-FF-FF-FF-FF
        - All nodes on LAN receive ARP query
    2. B receives ARP packet, replies to A with its (B's) MAC address.

#### Addressing: routing to another LAN
