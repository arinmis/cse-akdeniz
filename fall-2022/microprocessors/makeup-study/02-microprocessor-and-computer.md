# The Microprocessor
- The controlling element in a computer system.
- Controls memory and I/O through connection buses.
- Memory and I/O controlled via instructions
    * Stored in memory
    * Executed by microprocessor

# Buses
- A common group of wires that interconnect components in a computer sytem.
- Transfer address, data & control information between microprocessor, memory and I/O.
- 3 buses exists: address, data, control.

## The Adress Bus
Request a memory location from the memory or an I/O location from the I/O devices.
    - For I/O 16-bit address from 0000H through FFFFH.
    - For memory address, bus contains memory address(20-bit for 8086)  

Data transfers vary in size, 8086 transfer 16 bits of data.


Control bus lines select and cause memory or I/O to perform a read or write operation.
    * MRDC -> memory read control
    * MWTC -> memory write control
    * IORC -> I/O read control
    * IOWC -> I/O write control

# Number Systems
- Binary, decimal and hexadecimal must known before dive in the code.
## Digits
- Decimal: {0, 1, ..., 9}
- Octal: {0, 1, ..., 7}
- Binary: {0, 1}
- Hexadecimal: {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F}

## Positional Notation
132 is 100 * 1 + 10 * 3 + 1 * 2


## Whole Number Conversion from Decimal
Algorithm goes like this:
```
divide the decimal number by the radix
save remainder
repead steps 1 and 2 until the quotient is zero
```

## Converting from a Decimal Fraction
Algorithm goes like this:
```
multiply the decimal fraction by the radix
(number base).
save the whole number portion of the result
(even if zero) as a digit; first result is written
immediately to the right of the radix point
repeat steps 1 and 2, using the fractional part of
step 2 until the fractional part of step 2 is zero
```
## Binary Coded Hexadecimal
Each digit represented by 4-bit binary number. ```A = 1010``` for example

## Complements
Two's complements algorithm will happen as follow:
```
From left to right copy all bits as it is until first 1 and then convert 0 to 1 and 1 to 0.
```


# Computer Data Formats
## ASCII and Unicode
ASCII(American Standard Code for Information Interchange) data represent alphanumeric characters in computer memory. It is 7-bit code. Most significant 8 bit hold parity.  

Unicode stores 16-bit alphanumberic data.

## BCD(Binary-Coded Decimal)
