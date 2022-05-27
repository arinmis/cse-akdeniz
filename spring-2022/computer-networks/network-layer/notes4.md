## IP Addressing:

-   IP address: 32-bit identifier for host, router interface
-   Interface: connection between host/ router and physical link

### Subnets

-   Subnet part, high order bits
-   Host part, low order bits

What is subnet?

-   Device interfaces with same subnet part of IP address
-   can physically reach each other _without intervening router_.

-   to Determine subnet, detach each interface from its host or router, creating islands of isolated network, each isolated network is called _subnet_.

**Example:** 223.1.1.2/24

-   IP -> 223.1
-   subnet -> 1
-   host -> 2

#### CIDR: Class InterDomain Routing

a.b.c.d/x

| binary        | Dot-decimal Notation                |
| ------------- | ----------------------------------- |
| 192.168.5.130 | 11000000.10101000.00000101.10000010 |
| 255.255.255.0 | 11111111.11111111.11111111.00000000 |

Perform logical and upon IP with subnet mask.
IP = network prefix + host part

### DHCP: Dynamic Host Config Protocol

Allow host to dynamically obtain its IP address from network server when joins network.

1. host "DHCP discover"
2. DHCP server responds with "DHCP offer"
3. Host request IP address: "DHCP request"
4. DHCP server sends address: "DHCP ack"

All steps are broadcast to inform other DHCP server in the network.

-   DHCP does more than IP address, it also sends
    -   address of first-hop router for client
    -   name and IP address of DNS server
    -   network mask

ISP's buy IP's from ICANN.

#### Altering Addressing Model

-   Any host can act as server
-   public IP addresses
    -   not enough IP for every host
    *   don't want every machine in organization known to outside world.
    *   Want to control or monitor traffic in / out of organization.

#### Network Address Translation

-   distinguish local devices and public id relationship with port number

-   NAT router implement:
    -   outgoing datagrams: replace
        -   source IP, port #
        -   NAT IP, new port #
    -   remember(in NAT translation table)
        -   source IP, port #
        -   NAT IP, new port
    -   incoming datagrams: replace
