# Psudo-code convention
Example psudocode
```
for j = 2 to A.length
    key = A[j]
    i = j - 1
    while i > 0 and A[i] > key
        A[i + 1] = A[i]
        i = i - 1
    A[i + 1] = key
```

- Use indentation for block structure.
- Use C like languages element for code flow: while, for, if-else. 
- Use double slash for comments: // this is a comment
- A[i] indicates specific element of array, A[1..j] indicates subarray consisting of j element.
- Pass parameter by value
- **return** statement transfer control back to the point of call in the calling procedure. 
- Use **and**, **or** for boolean operations.

