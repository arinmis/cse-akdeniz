### Lathces 
- Storage elements that operate with signal levels
    * called *level sensitive devices*
    * Useful in asynchronous sequencial circuits
- Those controlled by a clock transition are flip-flops.

#### SR Latch(Active High)
- *two cross-coupled NOR(or NAND) gates*
- S -> set, R -> reset
- Q -> stored bit, Q' -> negated Q
- S and R cannot be 1-1 since it outputs 0-0 for Q-Q'.(see that Q and Q' cannot be same)
- Hazards are important stuff for Latchs. If some kind of mistakes sets the state for a just  short time(as input signal to S) latch will be store this state and it will store not desired bit.

- Active High -> NOR gates
- Active Low  -> NAND gates
