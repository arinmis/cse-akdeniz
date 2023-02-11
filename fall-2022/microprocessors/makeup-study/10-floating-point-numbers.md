# Floating Point Numbers
- General formula: significant digits x base ^ exponent
- Single Precision: 32 bits
    * Sign bit(1 bits)
    * Exponent(8 bits)
    * Mantissa(or fraction)(23 bits)

## Normalization
- The mantissa is normalized.
- Has an implied decimal place on the left.
- Single precision: excess 127
    * Exponent - Excess 
- Has an implied 1 on the left of the decimal place.
    * Mantissa -> 10100000000
    * Represents 1.101 = 1.625

- It is common to represent floating point in hexadecimal. 
