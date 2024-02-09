### System Clock
- 1GHz processor receives 1 billion pulses per second.
- Increasing frequency too much reduces stability of operations.

#### Benchmarks
- 


- Java
```
A = B + C
```

- CISC 
```
add mem(B), mem(C), mem(A)
```

- RISC 
```
load mem(b), reg(1)
load mem(c), reg(2)
add  reg(1), reg(2), reg(3)
store reg(3), mem(a) 
```

#### Amdalh's Law
sp <= 1 / [s + (1 - s) / N]

