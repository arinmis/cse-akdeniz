### 1.3 History of Computers
#### First generation: Vacuum-tube
- ENIAC
    * Decimal computer
##### IAS sturucture
<p align='center'>
<img src="https://user-images.githubusercontent.com/56651041/155521254-7845cbcb-52b6-446f-a99c-072c5a89a39e.jpg"/>
</p>
#####  John von Neumann
- He founded stored program concepts
    * Main memory -> stores both data and insturctions
    * ALU -> capable of operating on binary data
    * Control unit -> interprets the instructions in memory and causes to be executed
    * I/O -> equipment operated by the control unit
- Von Neumann architeture is still using.(IAS computer) 
- IAS memory consist of 40 bit
    * To store number: 1 bit for sign, 39 for value
    * To store instruction: Two 20 bit can be stored each 
        + 8 bit for opcode(operation code)
        + 12 bit for address
    * **Word**: ordered set of bytes, x bit CPU has x bit word.
    * I/O <-> Arithmetic-logic, Program control unit <-> Main memory
        + Program counter: decides which expression will be executedo

#### General Types of Instructions 
- Data transfer
- Unconditional branch
- Conditional branch
- Artihmetic
- Address modify

#### Registers
- One of the instructions parameter must be register
- Main memory is much more slow than CPU.
    * Fetching data from memory takes up to 300-400 ns
    * Machine cycle: fetch -> decode -> execute

### Second generation: Transistors 
    - More cheaper and produces less heat
### Second generation: Integrated Circuit 
- Two fundamental components required:
    * Gate
    * Memory
