### Tree
- Root: node without parent
- Depth of node: num of ancestors
- Height of tree: max. depth 
- internal nodes
- external nodes


#### Traversal Algorithms
- Systematic way to accessing data
#### Preorder
	visit
	go left 
	go right
#### Postorder 
	go left 
	go right
	visit
#### Inorder 
	go left 
	visit
	go right

### Binary Tree
- Constraints: max child nodes is 2

#### Properties of Binary Trees
- n: number of nodes
- e: number of external nodes
- i: number of internal nodes
- h: height


### Proper Binary Tree(2-tree)
- All nodes has exactly 2 children
- Should follow these rules
	* e = i + 1
	* n = 2e - 1
	* h <= (n - 1)/2 
	* e <= 2^h
	* h >= log<sub>2</sub>e
	* h >= log<sub>2</sub>(n + 1) - 1
- Rules can be use to prove speed of algorithm.
