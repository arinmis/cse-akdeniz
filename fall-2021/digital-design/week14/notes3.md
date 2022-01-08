### Sequential Logic
- It doen't consider state and time.
- Same input might be mapped different output. 
- Sequential logic includes feed back loops.
- It is possible to store information.
- *State* is snaphot of **memory elements** 
- Two types of sequential circuit available: 
    * Synchronous
         + whose behavior can be defined from the knowled of its signals at discerete instants of time  
         + Synchronization is acheved by *clock generator*
         + To perform operation, time clock has be waited.
    * Asynchronous
        + If it operation can be performed, it will be performed. No need to consider time.  
        + *Internal propagation delay of logic gates* is sufficient duration to produce the needed delay. 
        + AKA *combinational circuit with feedback*

### Synchronous Sequential Logic
- The storage elements used in clocked sequential circuits are called **flipflops**  
- A flip-flop can store **on bit of information**

- *stable value* should have reached.

- *speed ~ clock pulse frequency*  

- More speed might be broke system so that new instruction can be started to calculate before existing one is completed.    
