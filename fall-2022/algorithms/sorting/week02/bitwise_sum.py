def bitwise_sum(A, B):
    carry = 0
    C = [0] * 5
    for i in range(len(A)):
        total = carry + A[i] + B[i]
        if total == 0:
            C[i] = 0 
            carry = 0
        elif total == 1:
            C[i] = 1 
            carry = 0
        elif total == 2:
            C[i] = 0 
            carry = 1
        elif total == 3:
            C[i] = 1 
            carry = 1
    return C


A = [0, 0, 1] # 1
B = [0, 1, 1] # 3
print(bitwise_sum(A, B))
