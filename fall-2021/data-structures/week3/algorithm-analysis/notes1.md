# Algorithm Analysis
- Some definitions:
	* **Data Structures:** Systematic way of organizing and accessing data.
	* **Algorithm:** Step-by-step procedure ofr performing some task in *finite* amount of time.
- The more faster the algorithm, the better algorithm.
- Running time depends on input size.


## Experimental Approach 
- It literally suggest that run and measure running time.
- This approach has several disadvantages: 
	* Results are depend on *hardware* and *software*  enviroments of the machine.
	* It can be done only with limited input sizes.
	* Most importantly, an algorithm must be fully implemented.
- See my [string concatenation](https://github.com/Arinmis/cse-akdeniz/tree/main/fall-2021/data-structures/experiments/ex-1) experiment.

## Beyond Experiment
- Simply it suggest that the counting number of primitive operation will be proportional to running time of an algorithm. 
- Advantages:
	* It is independent of hardware and software.
	* No implementation is needed.
	* Takes into account all possible input.

### Primitive Operations
- Assignment 
- Following an object reference
- Arithmetic operations
- Accesing element of an array by index
- Returning from a method

- To calculate the running time given input size *n* each algorithm should associate with a function *f(n)*. 

### Focusing on the Worst-Case Input
- Using average-case would be better but it's is hard to calculate.(dealing with probability distribution) 
- Considering wors-case will improve an any alogritm. If it is fast enough in worst-case, it is quite a lot fast in average or best case. 






