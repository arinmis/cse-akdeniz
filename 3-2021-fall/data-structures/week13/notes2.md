### AVL Tree(Balanced)
- height of the chidlren of a tree can differ by at most 1, for each subtree. 
- By induction, height of the AVL tree is O(log n)

#### Insertion
- Put new value to appropriate place.
- Check violation for AVL constains.
- Fix them using rotation opeartions if violatoin exists.
- O(log n)

#### Removal
- Remove the appropriate node.
- Check violation for AVL constains.
- Fix them using rotation opeartions if violatoin exists.
- O(log n)
