### Edit Distance

##### a.
```python
min_edit_distance
```
##### b.
```python
min_edit_distance(x, y, n, m):
```
`min_edit_distance` takes two string and returns minimum edit distance between them.
* `x` first string
* `y` second string
* `m` is last index of the x where `0 <= n < x.length`  
* `n` is last index of the y where `0 <= m < y.length`  
##### c.
I assumed cost of edit, delete and insert takes **constant time**.

```python
min_edit_distance(x, y, n, m) = min_edit_distance(x, y, n , m - 1) + 1
```
##### d.
```python
min_edit_distance(x, y, n, m) = min_edit_distance(x, y, n - 1, m) + 1
```
##### e.
```python
min_edit_distance(x, y, n, m) =  min_edit_distance(x, y, n - 1, m - 1) +
								 0 if x[n] == y[m] else 1
```
##### f.
```python
min_edit_distance(x, y, n, m) =  min( 
		min_edit_distance(x, y, n , m - 1) + 1,
		min_edit_distance(x, y, n - 1, m) + 1
		min_edit_distance(x, y, n - 1, m - 1) + 1 if x[n] == y[m] else 0
	)
```

---

### Matrix Chain Multiplication

##### a.
```python
min_matrix_chain_multiplication
```
##### b.
```python
min_matrix_chain_multiplication(p, i, j) 
```

Computes **minimum cost** of way to multiply matrix chain.
* `p` is list of matrix dimension, `A[i]` = `p[i - 1] x p[i]`
* `i` start index of the sub-matrix chain
* `j` end index of the sub-matrix chain
##### c.

```python
min_matrix_chain_multiplication(p, i, j) =  
		min_matrix_chain_multiplication(p, i, i + 1) +
		min_matrix_chain_multiplication(p, i + 2, j) + 
		p[i - 1] + p[i + 1] + p[j]
```
(A1) x (A2 A3 ...)
 ##### d.
```python
min_matrix_chain_multiplication(p, i, j) =  
		min_matrix_chain_multiplication(p, i, i + 2) +
		min_matrix_chain_multiplication(p, i + 3, j) + 
		p[i - 1] + p[i + 2] + p[j]
```
(A1 A2 ) x (A3 ...)
##### e.

```python
min_matrix_chain_multiplication(p, i, j) =  min(
		[
			(min_matrix_chain_multiplication(p, i, k) +
			min_matrix_chain_multiplication(p, k  + 1, j) + 
			p[i - 1] + p[k] + p[j])
			for k in range(i, k) # for each k where i <= k < j 
		]
	) 
```

