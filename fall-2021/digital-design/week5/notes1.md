### Boolean Algebra
- Can have two values
	* 0, true or high
	* 1, false or low 
- Primitive Operation
	* AND
	* OR 
	* NOT

#### Boolean Function
- Boolean function has 
	* At least one Boolean Varible
	* At least one Boolean operator 
	* At least one input from the set {0, 1} 
- Boolean outputs always will be in the {0, 1}
**Example:** F(x, y z) = x.z' + y
- Priority of operations: NOT, AND, OR

#### Simplification
- Make the functions simple to get more cheaper, faster, less complex and consume less power hardwares
**Example:** F = X'YZ + XYZ' + XZ can be reduced to F = X'Y + XZ 

#### Boolean Algebra Laws
| Identity      | AND Form | OR Form |
| -----------   | ----------- | -----------|
| Identity L.   | 1x = x      | 0 + x = x  |
| Null L.       | 0x = 0      | 1 + x = 1  |	
| Idempotent    | xx = x      | x + x = 1  |		
| Inverse L.    | xx'= 0	    | x + x' = 1 |		
| Commutative L.| xy = yx	    | x + y = y + x |		
| Associative L.| xy(z) = x(yz)	    | (x + y) + z = x + (y + z) |		
| Distributive  | x + yz = (x + y) (x + z)| x (y + z) = xy + xz |		

| Absorption L.   | x (x + y) = x    | x + xy = x |
| DeMorgan's Law   | (xy)' = x' + y' |  (x + y)' = x'.y'|
| Double Complement L.| (x)'' = x |  (x)'' = x |
