## Several Important Functions 
- Knowing those several mathematical functions is mostly enough to analyze algorithm.

###  The Constant Function
*f(n) = c*  
for some c such as c = 15, c = 72 etc. Another say input *n* doesn't not matter in order to determine output.

###  The Logarithm Function
x = log<sub>b</sub>b if and only if b<sup>x</sup> = n  
- *b* is known as base of logrithm
- By the definition *b* > 0, we have that log<sub>b</sub>1 = 0
- **Note:** Base 2 is the most common base in computer science so it might be omitted.   
log(n)> =  log<sub>2</sub>n  
- In many case approximate result of logarithm is enough, use *ceil* function to get integer result.  
- **Examples:**  
	* *ceil*(log <sub>2</sub>8) = 3
	* *ceil*(log <sub>2</sub>12) = 4
	* *ceil*(log <sub>2</sub>16) = 3

#### Logarithm Rules
Given numbers a > 0, b > 1, c > 0, and d > 1  
1. log<sub>b</sub>(ac) = log<sub>b</sub>a + log<sub>b</sub>c
2. log<sub>b</sub>(a / c) = log<sub>b</sub>a - log<sub>b</sub>c
3. log<sub>b</sub>(a<sup>c</sup>) = c.log<sub>b</sub>a 
4. log<sub>b</sub>a =  log<sub>d</sub>a / log<sub>b</sub>b 
5. b<sup>log<sub>d</sub>a</sup> = a<sup>log<sub>d</sub>b</sup>

**Note:** Rule 4 gives us to be able to calculate logarithm in base 2 where
defult base is 10(LOG x =  log <sub>10</sub>x)  
log<sub>2</sub>n = LOG n / LOG 2 


### The Linear Function
*f(n) = n*  
- It represent best running time we can hope to achive to process each of n element. Because accessing n element already needs n reading opeation.   

### The N-Log-N Function
f(n) = n.log(n)  
- It is little bit slower than linear growth but it is absolutely preferred rather quadratic function.


### The Quadratic Function
f(n) = n<sup>2</sup>  
- Nested loops causes quadratic functions

#### Nested Loops
	for i = 1 to n
	  for j = 1 to i
	    // operation

Operation up above will be performed 1 + 2 + 3 + .. + (n - 1) + n times. Result can be found with famous Gauss sum formula:  
	1 + 2 + 3 + .. + (n - 1) + n = n * (n + 1) / 2 

### The Cubic and Other Polynomials 
f(n) = n<sup>3</sup>   
- It is not usual, but it might be appeared. 

#### Polynomials
- Linear, quadratic and cubic functions are also **polynomials** function.  
*Definition of Polynomials:* f(n) = a<sub>0</sub> + a<sub>1</sub>n + a<sub>2</sub>.a<sup>2</sup> + ... +   a<sub>d</sub>.a<sup>d</sup>  so that  a<sub>0</sub>,  a<sub>1</sub>,...,a<sub>d</sub>  are constants and called *coefficinets*.  
**Example:** f(n) = 1 + n<sup>2</sup>


#### The Exponential Function 
f(n) = b<sup>n</sup> so that *b* is base and *n* is exponent.  

##### Exponent Rules
1. (b<sup>a</sup>)<sup>c</sup> =  b<sup>ab</sup> 
2. b<sup>a</sup>b<sup>a</sup> =  b<sup>a+b</sup> 
3. b<sup>a</sup>b<sup>c</sup> =  b<sup>a-b</sup> 

#### Geometric sum
1 + a + a<sub>2</sub> + ... + a<sub>n</sub> = (a<sup>n+1</sup> - 1) /  a - 1

**Note:** It is helpful to know this equation while trying to find largest unsigned integer that consists of *n* bits:  
1 + 2 + 4 + 8 + ... + 2<sup>n</sup>  == 2<sup>n+1</sup> - 1

### Growth Rates
| constant      | logarithm     | linear        | n-log-n       | quadratic     | cubic         | exponential  	|	
|:-------------:|:-------------:|:-------------:|:-------------:|:-------------:|:-------------:|:-------------:|
| 1        	| log n       	| n 		| n<sup>2</sup> |n<sup>2</sup>  | n<sup>3</sup> | a<sup>n</sup> |
- from left to right, things getting slower
- For data structures it is good to have *constant* or *logarithmic* operations.
- For algorithm it is good to have *linear* or *n-log-n* run time.  


