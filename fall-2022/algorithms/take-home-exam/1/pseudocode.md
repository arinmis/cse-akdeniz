```
// arrays are 1 indexed, loops includes last check
PARTITION(A, l, h)
    p = h
    i = l
    for j = left to p - 1
        if A[j] < A[p]
            swap A[j] and A[i]
            i = i + 1
    swap A[i] and A[p]
    return i

FIND-MISSING-PATIENT(A, l, h)
    if h >= l
        p = PARTITION(A, l, h)
        if A[p] - p != 1
            FIND-MISSING-PATIENT(A, low, p - 1)
        else
            FIND-MISSING-PATIENT(A, p + 1, h)
```
