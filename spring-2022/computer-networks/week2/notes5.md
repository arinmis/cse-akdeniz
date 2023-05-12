### Hamming Distance   
- Number of bit positions in which they differ.
- D-1 bit errors can be detected.
- [(D-1)/2] errors can be corrected.

- _Example:_ Some of the characters represented with:
```
A -> 000
B -> 001
C -> 010
D -> 011
E -> 100
F -> 101
G -> 110
H -> 111
```

    * "bad" sending with string "001 000 011" but receiver recieves "101 000 011". It will be decoded as "fad".

    * _Solutions:_     
        1. Duplicate data

        ```
        A -> 000 000
        B -> 001 001
        C -> 010 010
        D -> 011 011
        E -> 100 100
        F -> 101 101
        G -> 110 110
        H -> 111 111
        ```
            * "bad" is sending with string "001 001 000 000 011 011" but receiver recieves "101 001 000 000 011 011". Error in the first character can be detected but cannot be corrected. 

        2. Parity Bit
            * Add even or odd parity bit to detect error. 
            * Detect single bit error
            * Even parity
                ```
                A -> 0000
                B -> 0011
                C -> 0101
                D -> 0110
                E -> 1001
                F -> 1010
                G -> 1100
                H -> 1111
                ```
        3. Triple data
            * Supports autocorrection, but works on 1 bit error 
            * Assumes most used one is correct.
            ```
            A -> 000 000 000 
            B -> 001 001 001
            C -> 010 010 010
            D -> 011 011 011
            E -> 100 100 100
            F -> 101 101 101
            G -> 110 110 110
            H -> 111 111 111
            ```
        4. Hamming Code:
            - Add extra bits, but use mapping smartly so that bit size will be as less as can.
