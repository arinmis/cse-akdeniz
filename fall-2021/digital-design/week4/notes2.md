### One's Complement
- To Obtain One's Complement
1. Find biggest number that has same number of digit within domain.   
**Example:** 
	* 0101 -> 1111
	* A3C -> FFF
2. Substract the number from the biggest number that founded in step 1 to obtain one's complement. 

- Sign Issue
* First bit represent sign 
	0 -> +
	1 -> -
* If number starts with 0, it means that the number is positive, to find magnitute just convert number to decimal
	- 0111 -> 7
* If number starts with 0, it means that the number is negative, to find magnitute take one's complement and then convert number to decimal
	- 1011 -> 0100 -> 4

### Two's Complement
- (2^n - 1) - N + 1
- Add 1 to one's complement to get two's complement
- This system includes only one '0'
- Faster approach to obtain two'w complement
	* Save including bits until first bit that is  1 that starting least significant bit 
	* Then invert rest of the bits 
 
