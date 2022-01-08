### Hazards
- When the input changes in combinational logic circuit, unexpected outputs might be occurs because of the propagation delay. 
- Untill total propagation *dt* has past, output won't be stable.

#### Timing Hazard
#### Static-0:
    - We exptected 0 but received 1 instead
    - Detecting Algorithm: 
        1. Write POS
        2. Plot each term on map and loop the zeros 
        3. If any two adjacent 0's are not covered within same loop, 0-hazard exists between the two 0's.  
#### Static-1:
    - We exptected 1 but received 0 instead
    - Detecting Algorithm: 
        1. Write SOP
        2. Plot each term on map and loop it
        3. If any two adjacent 1's are not covered within same loop, 1-hazard exists between the two 1's.  
#### Dynamic:
    - Multiple changes until it's became stable



