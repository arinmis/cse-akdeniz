# Addressing Modes
There are 3 types of addressing modes exists

1. Data Addressing Modes
2. Program Memory Addressing Modes
3. Stack Memory Addresing Modes

## Data Addressing Modes
**MOV** instruction is basis of data addressing modes.
- ```MOV AX, BX ``` is kind of ```AX = BX``` if we compare with high-level language.

| Type | Instruction | Source | Address Generation | Destination |
| -----| ----------- | ------ | ------------------ | ----------- |
| Register | MOV AX, BX | Register BX | - | Register AX |
| Immediate | MOV AX, 3AH | Data 3AH | - | Register CH |
| Direct | MOV [1234H], AX | Register AX | DS x 10H + DISP | Memory Adress 11234H |
| Register Indirect | MOV [BX], CL | Register CL | DS x 10H + BX | Memory Adress 10300H|
| Base-plus-index| MOV [BX + SI], BP| Register SP| DS x 10H + BX + SI | Memory Adress 10500H|
|Register Relative| MOV CL, [BX + 4] | Memory Address| DS x 10H + 4 | Memory Adress 10500H|
| Register Relative-plus-index | MOV ARRAY[BX + SI], DX | Memory Address DX|  DS x 10H + ARRAY + BX + SI | Memory Adress 11500H |
| Scaled Index | MOV MOV[EBX + 2 x ESI], AX | Register AX|  DS x 10H + EBX + 2 x ESI | Memory Adress 10700H |

**NOTE:** Use same size registers.

- Append **H** to end of the hexadecimal immediate like ```1234H```. 
- Append **B** to end of the Binary immediate like ```0000 1010H```. 
- Each assembly statement consist of four parts: label + opcode + operand + comment
    * ```MYLINE MOV AX, BX; this is an assembly line```

### Register Indirect addressing
- Address memory location with offset: BP, BX, DI, and SI.
    * BP register addresses memory, the **stack segment** is used by default.
- Indirect addresing sometimes require **special assembler directive** like BYTE PTR, WORD PTR, DWORD PTR, or QWORD PTR.
    * Indicates size of the memory data addressed by the memory **pointer**.

### Base-Plus-Index Addressing
Similar to indirect addressing, base hold beggining location of a memory array.

### Register Relative Addressing
Adds displacement addressing to index register.
```MOV AX, [BX + 1000H]```

## Program Memory Addressing Modes
Used with the **JMP** and **CALL** instructions. Three form exists:
1. Direct
**JUMP** and **CALL** is used.
2. Relative
It is relative to the instruction pointer (IP).
3. Indirect
Allows several forms of indirect addressing for the JMP and CALL.


## Stack Memory Addresing Modes
Holds temporary data and stores return addresses used by procedures. Stack memory is LIFO(last-in, first-out).
- Data placed to stack with **PUSH**.
- Removed from stack with **POP**.
Stack pointer(SP) or stack segment register(SS).  
```PUSH BX``` places the contents of BX onto the stack, ```POP CX``` removes data from the stack and places them into CX.

