# Programming Structure
Assembly instructions contains same instructions as machine language, but with mnemonics. 
- Every CPU has unique machine language.

# Software Development Flow
- Compiler translates to assembly
- Assembler translates to machine language
- Linker combines object files to single executable.


# Inside Intel 8086
The 8086 is a 16-bit microp- Indicate the condition of microprocessor and control its operation.
- Flags never change for any data transfer or program control operation.

|Flag| Purpose|
|----|--------|
|C(carry)|Holds the carry after addition or borrow after substraction|
|P(parity)|count of ones in a number even or odd|
|A(auxiliary carry)|Holds carry(half-carry)|
|Zero(zero)|Result of an arithmetic or logic operation is zero|
|Sign(sign)|Flag holds the arithmetic sign of the result|
|T(trap)|enables trapping through an on-chip debugging|
|I(interrupt)|controls operation of (interrupt request) input pin|
|D(direction)|selects increment or decrement mode DI or SI|
|O(overflow)|occurs when signed numbers are added or subtracted|rocessor chip designed by Intel in 1978, which gave rise to the x86 architecture. 

- Registers, internal and external buses are 16 bit wide.
- Clock rate is 5MHz.
- A 20-bit external address bus gives 1MB (segmented) physical address space.
- 16-bit I/O addresses give 64KB of separate I/O space.
- 8086 divided into two separate unit
    1. Bus Interface Unit(BIU)
    2. Execution Unit(EU)

## Bus Interface Unit
The BIU sends out address, fetches insruction from memory, reads data from ports and memory and writes data to ports and memory. Handles data and addresses transfer on the buses.

## Instruction Queue
- Prefetches some instructions while EU decoding and excuting.
- Fetching while current instruction executes is called Pipelining.

## Execution Unit
- Where to fetch instructions or data from.
- Decodes instruction and executes instructions.
- EU contains 16 bit ALU which can perform arithmetic and logical operations.
- Basic Instruction Cycle: Fetch-decode-execute
    * fetch instruction
    * increment PC
    * decode 
    * execute

# Internal Microprocessor Architecture
- 8086 considered **program visible**.
    * Some of the registers are used during programming.
- **Program Invisible** registers can't be addressed by registers. 


# Multipurpose Registers

| Purpose | 64-bit | 32-bit | 16-bit | 8-bit | 
| ------- | ------ | ------ | ------ | ----- |
| **Accumulator** used for instructions such as multiplication or division | RAX | EAX | AX | AH and Al |
| **Base Index** holds offset address of a location in the memory| RBX | EBX | BX | BH and AH |
| **Count** holds count for various instructions| RCX | ECX | CX | CH and CL |
| **Data** part of multiplication of division| RDX | EDX | DX | DH and DL |
| **Base Pointer** points location for memory data transfers| RBI | EBI | BI | - |
| **Destination Index** destination data for the string instructions| RSI | ESI | SI | - |
| **Source Index** addresses source string data for the string instruction| RDI | EDI | DI | - |

# Special-Purpose Registers

## RIP(Instruction Pointer)
Addresses the next instruction in a section of memory.

## RSP(Stack Pointer)
Addresses an area of memory called stack

## RFLAGS
- Indicate the condition of microprocessor and control its operation.
- Flags never change for any data transfer or program control operation.  
|Flag| Purpose|
|----|--------|
|C(carry)|Holds the carry after addition or borrow after substraction|
|P(parity)|count of ones in a number even or odd|
|A(auxiliary carry)|Holds carry(half-carry)|
|Zero(zero)|Result of an arithmetic or logic operation is zero|
|Sign(sign)|Flag holds the arithmetic sign of the result|
|T(trap)|enables trapping through an on-chip debugging|
|I(interrupt)|controls operation of (interrupt request) input pin|
|D(direction)|selects increment or decrement mode DI or SI|
|O(overflow)|occurs when signed numbers are added or subtracted|


## Segment Registers
Generate memory addresses when combined with other registers. They functions differently in real mode than in protected mode.

|Register|Purpose|
|--------|-------|
|CS(code)|Holds code (program and procedures)|
|DS(data)|Contains most data used by a program| 
|ES(extra)|Additional data segment used by some instructions to hold destination data|
|SS(stack)|Area of memory used for the stack|


# Real Mode Memory Addressing
- Real or protected mode supported.
- Real mode operation allows addressing of only the first 1M byte of memory space also called(real memory, conventional memory, DOS).

## Segments and Offsets
- Segment + offset addresses selects memory location.
    * **Segment address:** defines the beginning address, any 64K-byte.
    * **Offset address:** selects any location within the 64K byte memory segment.
- The **code segment** register defines the start of the code segment
- The **instruction pointer** locates the next instruction within the code segment.
- **Stack** referenced through stack segment and stack pointer or pointer.  

- A program can have more than four or six segments. 
    * But only access four or six segments at a time.
- Area is indicated by a **free-pointer** maintained by DOS.
- Program loading is handled automatically by the **program loader**.
- Memory segment can be moved to any place in the memory system without changing offset addresses.


# Protected Mode Memory Addressing
Allow access to data and programs located within & above first 1M byte of memory.
- **Protected mode** is where Windows operates.
- In segment address, the segment register contains a **selector** that selects a descriptor from a descriptor table.
- **Descriptor** describes the memory segment's:
    * Location
    * Length
    * Access rights
- The **descriptor** is located in the segment register & describes the location, length, and access rights of the segment of memory. 
    * Selects one of the 8192 descriptor from one of the two tables.

# Flat Mode Memory
There is no segmentation.
