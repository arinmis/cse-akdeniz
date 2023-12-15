# Intro To I/O Interface
- ```IN```, ```INS```, ```OUT```, ```OUTS``` are I/O instructions.


## I/O instructions 
- ```OUT``` transfers information to an I/O device.
- ```IN``` reads from and I/O device.
- ```INS``` and ```OUTS``` transfers strings of data between memory and I/O.
- ```IN``` and ```OUT``` transfers data between I/O and microprocessor's ***via accumulator(AL, AX, EAX)**.
- I/O address is stored in register DX as 16-bit address.
- 16-bit address is called a **variable address**.
- ```INS``` and ```OUTS``` instructions also use DX, I/O ports are 8 bits in width.

- I/O ports are 8 bits in width.


- ```INS``` and ```OUTS``` instructions address and I/O device using DX register.
    * Data transferred between I/O device and memory.

- Example I/O instructions: ```IN AL, p8```, ```OUT p8, AL```, ```IN AL, DX```, ```IN AL, DX```.


## Isolated(direct) and Memory-Mapped I/O
There are two methods of intefacing I/O
1. Isolated I/O
Transfers data between the microprocessor's accumulator or memory and the I/O device.
2. Memory-mapped I/O
In memory-mapped I/O, any instruction that references memory can accomplish the transfer


### Isolated I/O
I/O locations are isolated from memory in a seprate I/O address space. Those isolated I/O devices are called ports.  
Disadvantage is all the data must be accessed only with ```IN```, ```INS```, ```OUT```, and ```OUTS``` instructions.

- 8-bit port address is used to access devices located on the system, such as the time and keyboard. 
- 16-bit port is used to access serial and parallel ports, vidoe and drive systems.

### Memory Mapped I/O
Does not use ```IN```, ```INS```, ```OUT```, or ```OUTS``` instructions. 
- Advantage is any memory instruction can be used to access the I/O device.  
- Disadvantage is a portion of memory system is used as the I/O map.
    * Reduce memory available to applications.

### Personal Computer I/O Map
- I/O space between ports 0000h and 03FFh is normally reserved for the system and ISA bus. 
- 0400h-FFFFH for user application.

## Handshaking
- I/O devices are slower than the microprocessor.
- A method of I/O control called **handshaking** or **polling**, synchronizes the I/O device with the microprocessor.
- The strobe signal sends the data into the printer so that they can be printed.
- The software polls BUSU pin to decide printer availability. This process is called **handshaking**.
    * If the printer is busy, the processor waits.
    * If not, the next ASCII character goes to the printer.


## I/O Communication Methods
1. Serial Communication
Send one bit at a time. Examples:
    - RS-232
    - USB
    - Ethernet
    - Sata 
    - PCI
2. Parallel Communication
Send several bits together on a link. Examples:
    - Printer port
    - ATA(Advanced Technology Attachment)
    - SCSI
    - PCI Expess


### Serial vs Parallel
- Serial circuitry is cheaper than parallel.
- Synchronization is necessary for parallel.
- In serial problem no need to synchronize.
- After a certain speed and distance threashold, serial communication is superior.
