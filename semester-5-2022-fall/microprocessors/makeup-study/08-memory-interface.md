# Memory Devices
There are four types of memory:
    - Read-Only Memory(ROM)
    - Flash Memory (EEPROM)
    - Static Random Access Memory (SRAM)
    - Dynamic Random Access Memory (DRAM)

Memory pin connections:  
    - Address inputs    
    - Data outputs or I/O
    - Selection input
    - Read or write operation


## Address Connection
Memory devices have address input to select a memory location within the device. Addresses are zero indexed.  

A 1K memory device has 10 address pins. Number of memory location can be derived from number of pins. 


## Data Connections
All memory devices have a set of data outputs or input/outputs.

Data pins on memory devices are labeled D0 to D7 for an 8-bit-wide memory device. Most of the devices are **byte-wise** memory.

## Selection Connections
An input to select memory device. Called **chip select(CS)**, **chip enable(CE)** simply **select(S)**.


## Control Connections
All memory devices have some form of control input or inputs.
- ROM usually has one control input, while RAM often has one or two control inputs.

- RAM has either one or two control inputs.
    * Often called R/W.

- If the RAM has two control inputs, they are usually labled W and G.
    * Write enable must be active to perform memory write, G active to perform a memory read

## ROM Memory
**Read-only memory(ROM)** permanently stores data resident to the system. It is **nonevolatile memory** since not change even power is disconnected.
    - Programmed during fabrication

EPROM(erasable programmable read-only memory) is commonly used when software must be changed often.

PROM(programmable read-only memory) is also programmed in the field buring, and once it programmed it cannot be erased.


RRM(read-mostly memory) is called **flash memory**.

## Static RAM(SRAM) Devices
- Retain data as long as DC power is applied.

Difference between ROM and RAM is that, RAM is written under normal operation whereas ROM is programmed outside the computer and normally is only read.

### Dynamic RAM(DRAM) Memory
Integrated capacitor is used, after 2 to 4 ms, contents of the DRAM must be completely rewritten(refreshed).  
Lastes DRAM is the DDR(double-data rate) memory device and DDR2.

- SRAM vs DRAM
    * SRAM is faster than DRAM
    * SRAM  consumes less power
    * SRAM consumes more transistor per bit of memory, so its is expensive.
    * DRAM is used for main memory while SRAM is commonly used in cache memory. 


## Address Decoding
To attach a mrmory device to the microprocessor, ti is necessary to decode the address sent from the microprocessor.

## Simple NAND Gate Decoder
EPROM only use address A10-A0 and other 9 bits are not neccesary, those bits are connected to NAND gate.

PLD Programmable Decoders

## Error Detection and Correction
Parity, BCC(Block-Check Character) and CRC(Cyclic Redundancy Check) are only mechanicsms for error detection.

## Error Correction
Error correction is based on Hamming codes.
