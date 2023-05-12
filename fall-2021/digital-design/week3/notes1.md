### Binary Codes
- Subset of n bit binary numbers can address
can be mapped 2^n different value.  
  00 -> red
  01 -> green 
  10 -> blue 
  11 -> orange
- Number of required bits:
  * To represent M element
    2^n >= M > 2^(n - 1)
  * n = ceil(log2(M))
  **Example:** Decimal digits can be represented by 4 bits because of ceil(log2(10)) = 4 
### One Hot Coding
- Just one of the bit of string is 1
  0001 -> red
  0010 -> green 
  0100 -> blue 
  1000 -> orange
- It supports radix r amount of value.

### Binary Coded Decimal(BCD)
  - Every decimal digit represented by binary respondances.
  - 9 + 1 = 10 to obtain digit 0 we should add 6 to binary code.

### Gray Code
  |Decimal | Binary | Gray   |
  |--------|--------|--------|
  | 0      | 0000   | 0001   | 
  | 1      | 0001   | 0011   | 
  | 2      | 0010   | 0010   | 
  | 3      | 0011   | 0110   | 
  | .      | ....   | ....   | 
  |14      | 1110   | 1001   | 
  |15      | 1111   | 1000   | 

- Gray codes is more efficient in terms of signal changes in next and previous values.

- It is easy to debug since just one signal changes will occur when gray code increased or decread by 1.

**Note:** Converting and coding are different concepts
