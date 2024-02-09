## 4. LAN
- Addressing, ARP 
- Ethernet
- Switches
- VLANS

###  MAC addresses and ARP
- 32-bit IP address:
    * Network-layer address for interface
    * Used for layer 3(network layer) forwarding

- MAC (or LAN or physical or Ethernet) address
    * Get frame from one interface to another physically connected interface(IP in same network)
    * 48-bit MAC addresses burned in NIC ROM
    **EXAMLE MAC Adresses:** 1A-2F-BB-76-09-AD

**Note:** WiFi repeater and hub doesn't need any MAC addresses.

**Note:** All the devices should implement its and its lower levels.

- Manufacturer buys portion of MAC address space to ensure uniqueness

- MAC adress: like Social Security Number, portable  
- IP address: like postal address, not portable

#### ARP: Address  Resolution Protocol
ARP table: 
    * IP/MAC address mapping for LAN
    * TTL(Time To Live): how long entry is valid 

- A wants to send datagram to B.
    1. A Broadcast query packet, containing B's IP address.
        * dest MAC address = FF-FF-FF-FF-FF-FF
        * all nodes on LAN receive ARP query
    2. B receives ARP packet replies to A with its (B's) MAC address. 
        * Sent with unicast
    3. A chaches  IP-to-MAC pair address in its ARP table.

- Send datagram from A to B via R

#### Ethernet 
- Dominant LAN technology
- Pyhsical Topolgy
    * Bus
    * Start
- Frame structure
    * Addresses: 6 byte source
    * type 
    * CRC
- unslotted CSMA/CD binary backoff 

