# Socket Abstraction
Application, and process, controlled by app developer. Transport layer and below controlled by OS. Socket is  an interface, a door, between application process and end-end-transport protocol.   
Two types of socket supported: UDP and TCP

## UDP Sockets
- No connection between client and server, no handshake.
- Sender explicitly attaches IP and port to packet
- Receiver extracts sender IP address and port from received packet.
**NOTE:** Transmitted data may be lost or received out-of-order

## TCP Sockets
- Connection oriented.
- When contacted by client, _server creates new TCP socket_ to commuticate particular client. 
    * Allows server to talk with multiple client
    * source port distinguish the client.
