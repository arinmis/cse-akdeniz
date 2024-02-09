# Program Flow Control
To make decision, use **JUMP** instruction. There are two types of _JUMP_ instruction: conditional and unconditional.

## Unconditional Jumps
- ```JMP <label>``` is the sytax. 
**NOTE:** Label can declared with column syntax ```<label>:```.

- There are 3 types of ```JMP`` instruction:
1. Short Jump
2. Near Jump
3. Far Jump
Short and Near Jump is intrasegment, far is intersegment jump.


### Short Jump
Jump address is not stored in the opcode, instead _distance_ follows the opcode. Range between -128 and +127.

### Near Jump
Near jump is similar to the short jump, distance is farther: +-32K.

### Far Jump
A far jump instruction obtains a new segment and offset address to accomplish the jump.


## Conditional Jumps
Performs **JUMP** based on condition.  Only conditional _jump_ allowed. For example:
- These instructions are divided in three groups:
    * single flag
    * number as signed
    * numbers as unsigned

```
JC <label>
```

## Hacking Conditional Jump Limitation
Contitional jump can only jump 127 bytes forward and 128 byte backward. Solution is jumping to unconditional jump.

## LOOP
LOOP is similiar to JMP. **LOOP** decrement CX and JNZ conditional jump.
- if CX != 0, jump to label
- if CX becomes 0, the next sequential instruction executes.

## Conditional LOOPs
- **LOOPE(loop while equal)**
    * if CX != 0 while an equal condition exists
- **LOOPNE(loop while not equal)**
    * if CX != 0 while not-equal condition exists.

## Nested Loops
All loop instruction use CX, so in order to nest them PUSH the original value to CX and then POP.


## Procedures
Procedures are group of instructions that usually performs one taks. Also called subroutine, method, or function. Syntax is like below:
```
<name> PROC
    ; lines of codes
RET
<name> ENDP
```
- To exucute a procedure one can call ```CALL```  instruction with the name of the procedure.


### CALL
Transfers the flow of the program the procedure. ```CALL``` saves return address on the stack. 
- _RET_ returns from a procedure by removing the return address from the stack and place it into IP. 

### Passign Parameter To a Procedure
There are couple of ways to do it:
1. Using Registers
2. Using Stack
Put parameters to register, and desing your procedure to handle it. 
Push parameters to stack, and desing your procedure to handle it. 
