# Arithmetic and Logic Instructions
Most arithmetic instructions affect the **FLAGS** register.
- **Carry Flag(C):** normally 0, setted to 1 when there is _unsigned overflow_. 

- **Zero Flag(Z):** setted to 1 when result is zero otherwise 0.  
- **Sign Flag(S):** setted to 1 when result is negative otherwise 0.  
- **Overflow Flag(O):** setted to 1 when there is signed overflow. 
- **Parity Flag(P):** setted to 1 when there event number of one bits in result. 
- **Auxiliary Flag(A):** setted to 1 when there unsigned overflow. 
- **Interrupt Enable Flag(I):** setted to 1 when CPU reacts to interrupts from external devices. 
- **Direction Flag(D):** for 0 process is done forward, else process is done backward.


## Addition
**NOTE:** Memory-to-memory and segment resgister addition not allowed.  
- ```ADD``, ```ADC```, and ```INC``` is special type of addition that adds to 1. 
- Algorithms:
    * ADD 
        ```
        ADD AX, BX; AX = AX + BX
        ```
    * INC 
        ```
        INC AX; AX = AX + 1 
        ```
    * ADC: add bits to operand data
        ```
        ADC AX, BX ; AX = AX + BX + CF
        ```

## Subtraction
* ```SUB AL, 3 ; AL = AL - 3```
* ```DEC AL  ; AL = AL - 1```
* Subtraction-with-Barrow: carry flag holds barrow 
    ```SSB AL, 5; AL = AL - 5 - CF```

## Comparison
```CMP``` substract two operand and sets zero flag to 1.


## Mutliplication
Instruction contains one operand, it multiplies the operand times the contents of the register AL/AX. 
- When operand is a byte
```
AX = AL * operand
```
- When operand is a word
```
DX AX = AX * operand
```
- Signed multiply  ```IMUL```
```
AX = AL * operand
```

## Division
```IDIV``` signed number, ```DIV``` for unsingned. No immediate allowed.
- Division Errors:
    * attempt to divide by zero.
    * other is a divide overflow.

## The Remainder
```DIV`` instruction works like this:
- AL = AX / operand
- AH = remainder(modulus)


## BCD and ASCII Arithmetic


## AND 
Performs logical multiplication. It is used for masking.

## OR
Performs logical addition.

## XOR
Performs logical addition.

## Test and Bit Test Instructions
- **TEST** performs the AND operation.  only effects the condition of the flag register.
    * Functions the same manner as ```CMP```.
    * Only effects the condition of the flag register. 

## NOT and NEG
- NOT inverts all bits.
- NEG two's complements a number.

## Shift and Rotate
```SHL```, ```SAL```, ```SHR```, ```SAR```
