# Machine Language
Instruction control microprocessor's operations and its length varies 1 to 13.

## The Opcode
Selects the operation(addition, substraction etc.).

### MOD Field
Specifies addressing mode. 
### Register Assignmets
### R/M Memory Addressing

## Data Types
There are couple of data types exists.
- BYTE PTR
- WORD PTR
For example:

```
MOV AL, BYTE PTR [BX] ; byte access 
MOV CX, WORD PTR [BX] ; word access
```

# MOV Instruction
- Copies the **second operand(source)** to the first **operand(destination)**.
- **MOV** instruction _cannot_ set CS and IP.
- Source operand can be:
    * immediate
    * register
    * memory
- Destination operand can be:
    * memory
    * register

## Segment Register Operands
- For segment registers only these types of **MOV** are supported.
    * MOV SGREG, memory
    * MOV memory, SGREG   
    * MOV REG, SGREG   
    * MOV SREG, REG   

- **SREG:** DS, ES, SS and CS as second operand.
- **REG:** AX, BX, CX, DX, AH, AL, BL, BH, CH, CL,
DH, DL, DI, SI, BP, SP.
- **Memory:** [BX], [BX + SI + 7] 

Example code:
```
ORG 100h            ; this directive required
MOV AX, 0B800h      ; set AX to hexadecimal value of B800h.
MOV DS, AX          ; copy value of AX to DS.
MOV CL, 'A'         ; set CL to ASCII code of 'A', it is 41h.
MOV CH, 11011111b   ; set CH to binary value.
MOV BX, 15Eh        ; set BX to 15Eh.
MOV [BX], CX        ; copy contents of CX to memory at B800:015E
RET                 ; returns to operating system.   
```

## Varibles
- Syntax:
```
name DB value
name DW value
```
use __?__ mark to not initialize value.

```
ORG 100h
MOV AL, var1
MOV BX, var2
RET ; stops the program.
var1 DB 7
var2 DW 1234H
```


## ORG Directive

- ```ORG 100h``` is a assembler directive(tell to assmebler how to hande source code).
- 100h is offset to hold data about offset **CS(code segment)**, like command line parameter. 


## Arrays
Chain of variables. Text string is byte array.
```
a DB 48h, 65h, 6Ch, 6Fh, 6Fh, 00h
b DB 'Hello', 0
```

Access elements with square bracets([])
```
MOV SI, 3
MOV AL, a[SI]
```

- Use ```DUP``` to declare large array.
```
c DB 5 DUP(9)
```
is same as 
```
c DB 9, 9, 9, 9, 9
```

# Getting Adress of Varible
```LEA`` instruction can be used to get the offset addres of a varible.
For example: 
```
ORG 100h
MOV AL, VAR1            ; check value of VAR1 by moving it to AL.
LEA BX, VAR1            ; get address of VAR1 in BX.
MOV BYTE PTR [BX], 44h  ; modify the contents of VAR1.
MOV AL, VAR1            ; check value of VAR1 by moving it to AL.
RET
VAR1 DB 22h
END
```

# Constants
Only exist until your program is compiled(assembled). After definition it cannot be changed. Syntax is:
```
myConstant EQU 5
```
## PUSH
Always transfers 2 bytes of data to the stack. 
- ```PUSHA``` (ALL) instruction copies contents of the internal register set, except segment registers.
- ```PUSHF``` push flags) copies contents of the internal flag registers to stack.
- ```PUSHAD``` push content of register set.


## POP
Removes data from stack an places in target 16-register, segment register or memory location.
- ```POPF``` (pop flags) removes data from the stack.
    * ```POPFD``` (pop flags) removes 32-bit number from the stack places into the extended flag register.
- ```POPA``` (pop all) remove 16 bytes of data from the stack and places them into the following registers, in the order shown: DI, SI, BP, SP, BX, DX, CX, and AX.


## String Data Transfer
D flag bit, DI and SI must be understood to apply string instructions.  
- Memory accesses occur through DI and SI register. 
    * DI offset address accesses data in the extra segment for all string instructions.
    * SI offset address accesses data by default in the data segment.

### LODSB Instruction
Load byte at DS:[SI] into AL. Update SI.
```
AL = DS:[SI]
```
```
if DF = 0 then
    SI = SI + 1
else
    SI = SI - 1
```

### STOSB Instruction
Store byte in AL into ES:[DI]. Update DI

```
ES:[DI] = AL
```
```
if DF = 0 then
    DI = DI + 1
else
    DI = DI - 1
```


### MOVSB Instruction
It does operation for both: ```STOSB``` and ```MOVSB``



### IN and OUT
Performs I/O operations. Contents of AL, AX, or EAX.
