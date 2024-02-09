### Binary Search Tree
- It is proper binary tree.
- For nodes from left to right u, v, and w:
    * key(u) <= key(v) <= key(w) 

#### Insertion
- Put new node where it can fit.

#### Deletion
```
if extornalNode 
    remove node
else
    find following value with inorder traversel.
    put where the node deleted

```

### Performance of Binary Tree
- If tree isn't proper, searching might be O(n) instead of log(n)
- Tree balance must be maintained

#### Balanced Search Trees
1. Roation Op.
    - *Rebalancing a binary tree* is known as a rotation.
    - It needs just two pointer change so runs in O(1), constant time.
    - Rotation types:
        * Left rotation
        * Right rotation
        * Double rotation:
            + right & left rot.

