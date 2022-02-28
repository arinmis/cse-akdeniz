### 1.1 Computer Organization vs. Architecture
- Organization: optional units and their interconnections that realize the architectural specifications. 
- Architecture: System visible to a programmer, direct impact on the logical execution of to program. 

### 1.2 Structure and Function
- **Structure:** The way in which the components are interrlated
    * Central processing unit(CPU) (if more than one, called multicore)
        + Control unit
        + Arithmetic and logic unit(ALU)
        + Register
        + CPU interconnection
    * Main memory
    * I/O 
    * System interconnections 
- **Function:** The operation of each individual component as part of the structure.
    * Data processing
    * Data storage
    * Data movement: I/O - peripheral
    * Control
- *Chip* is a single piece of semiconducting meterial

- Each core contains: 
    * Instruction logic: fetch and decode instuction
    * Arithmetic and logic unit(ALU): Performs the operation specified by an instruction
    * Load/store logic: Manages data transfer to memory via cache.

- Suimulator maps one instruction set to another set.
- x64 -> amd 64
