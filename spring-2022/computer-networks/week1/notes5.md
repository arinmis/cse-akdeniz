### Internet Protocol Stack
| Network Stack |
| ------------  |
| application   |
| transport     |
| network       |
| link          |
| physical      |

1. Application: supports network applications
    * FTP, SMTP, HTTP
2. Transport: process-to-process data transfer
    * TCP, UDP
3. Network: Routing of datagrams from source to destination
    * IP, routing protocol
4. Link: data transfer between neighboring network elements
    * Ethernet, 802.111(WiFi), PPP
5. Physical: Bits "on the wire"

#### ISO/OSI reference model
| Network Stack |
| ------------  |
| presentation  |
| session       |
| application   |
| transport     |
| network       |
| link          |
| physical      |

- **Presentation:** Allow applications to interpret meanining of data
- **Session:** Synchronization checkpoint

#### Encapsulation

| Network Stack | Data          |
| ------------  | ------------  |
| application   | message       |
| transport     | segment       |
| network       | datagram      |
| link          | frame         |
| physical      |               |

#### Network Security
- Internet not originally desinged with security in mind
- Malwares:
    * **virus**: self-replicating infection by receiving/executing object
    * **worm**: self-replicating infection by passively receiving object that gets itself executed
    * **Denial of Servies(DoS)**: Making too busy attacked server
    * **Packet sniffing**: 
    * **IP spoofing**: 

