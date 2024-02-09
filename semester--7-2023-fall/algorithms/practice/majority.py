def isMajority(A, x):
    return True if len([n for n in A if n == A[x]]) > len(A) / 2 else False



def majority(A, l, r):
    if l == r:
        return A[l]
    mid = (l + r) // 2

    leftMajority = majority(A, l, mid)
    rightMajority = majority(A, mid + 1, r)

    if leftMajority == rightMajority:
        return leftMajority 

print(isMajority([1, 2, 2, 2, 1, ], 0))

