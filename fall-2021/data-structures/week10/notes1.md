### Prioritie Queues
- Use it when FIFO is not enough
- **get** return most priority object
- Two approach is used: 
	* Keep sorted, and add exact index
	* Keep randomly, sort and find the most priority object when it is requested

#### Entry ADT
- An entry in a priority queue is simply a key-value pair
- Key must be comparable
- Comparison can be implemented with *Comarator* interface.

### Priority Queue Sorting
- Put values to priority queue, it keeps the values sorted
- Then pull back sorted values from priority queues
- It runs in O(n^2) time comp.
**Note:** in place insertion sort is important


### Heaps
- It allows us to perform both insertions and removals in logrithmic time.
- Stores keys at its nodes

#### Insertion into a Heap
1. finds the insertion node
2. store at the node 
3. Restore heap order

- **Upheap:** interchanging child and parent until heap order is met.

#### Removal from a Heap
1. Access root node(constant time)
2. Put last node to root(maintain complete binary tree)(constant time)
3. Maintain heap order(with downheap operation).(worst case log(n))

- Accesing priority node is constant time, root node stores it

### Heap-sort
### Merging two heaps

complete binary tree usually allow log n operations.


#### Hea[ rules
- Complete binary tree
- key(v) >= key(parent(v))

