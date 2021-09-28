### Base Conversation

### Common bases
- Binary:       2 
- Octal:        8
- Decimal:     10
- Hexadecimal: 16

#### Example binary to decimal: 
Converting  (11010)2 to decimal  
result = 1 * 2^4 + 1 * 2^3 + 0 * 2^2 + 1 * 2^2 + 1 * 2^1 + 0 * 2^0  
= 16 + 8 + 0 + 4 + 0 = (27)10

#### Example decimal to binary: 
Convert 625(base 10) to binary  
- 625 - 512 = 113 -> 9
- 113 -  64 =  49 -> 6
-  49 -  32 =  17 -> 5
-  17 -  16 =   4 -> 4
-   1 -   1 =   0 -> 0 
Right most numbers gives us position of 1s so
(625)10 = (1001110001)2

##### Other method
- Convert 45 yo base 2
    * 46 / 2 = 23 remainder = 0
    * 23 / 2 = 11 remainder = 1
    * 11 / 2 =  5 remainder = 1
    *  5 / 2 =  2 remainder = 1
    *  2 / 2 =  1 remainder = 0
    *  1 / 2 =  0 remainder = 1
- Put right most digits backward, so 
 * 45 in decimal equal to 101110 in binary

#### Example floating point
Convert 0.2 to binary 
    * 0.2 * 2 = 0.4 int = 0
    * 0.4 * 2 = 0.8 int = 0
    * 0.8 * 2 = 1.6 int = 1
    * 0.6 * 2 = 1.2 int = 1
    * 0.2 * 2 = 0.4 int = 0
    * 0.4 * 2 = 0.8 int = 0
    * 0.8 * 2 = 1.6 int = 1
    *         .
    *         .
    *         .
So result repeating patterns of .00110 
