### Breadth-First Tree Traversal

	Algorithm breadthfirst( ):
		Initialize queue Q to contain root()
		while Q not empty do
			p = Q.dequeue() { p is the oldest entry in the queue }
			perform the “visit” action for position p
			for each child c in children(p) do
				Q.enqueue(c) { add p’s children to the end of the queue for later visits }


### Array Based Binary Tree
- The more proper, the more faster algorithm.
