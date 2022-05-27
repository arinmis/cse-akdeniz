### 5. Multiple Label Switching(MPLS)

-   high-speed IP forwarding using fixed length label.

### 6. Data Center Networking

-   Challenges
    -   Multiple app, each serve massive num. of client
    -   managin/balancing load, avoiding processing, networking, data bottlenecks

### 7. Day in the life, web request

Request google.com via campus internet

1. DHCP assign IP address dynammically to laptop
2. Ethernet frame broadcast on LAN, received at router running DHCP server.
3. After client recieves DHCP ACK reply, it has:
    - it's own IP.
    - name and address of DNS server.
    - IP address of its first-hop router.
4. With ARP broadcast, take router's MAC address.
5. Send datagram containing DNS query.
6. Web server responds with HTTP reply.
