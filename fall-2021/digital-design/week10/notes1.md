# Gate Level Minimization
- It aims to find optimal gate level implementation of Boolean function.
- The more simpler circuit, the more cheap harwares.
- It is hard to simplify boolean function that has more than few input without error free.

## The Map Method
- Pictorial form of a truth table, **Karnaugh map** or **K-map** 

### K-Map
- Simplest algebraic expression consists of:
	* minimum number of terms.
	* The smallest possible number literals
- A Kmap has a cell for each minterm.
- Indeces are Gray code.  

#### K-Map rules
- #adjacent square -> 2^n   
- Every 1's must present in at least one group
- Groups only contains 1, not 0. 
- Use right angles.(wreck around is valid)
- The groups mus be made as large as possible.
- Groups can overlap and wrap around the sides of th Kmap. 

- **NOTE:** Changing only one thing at one step clearly shows the what are mistakes.
