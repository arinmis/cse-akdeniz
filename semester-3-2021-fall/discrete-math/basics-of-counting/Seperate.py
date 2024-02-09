''' 
how many valid solution to this equation
x1 + x2 + x3 + x4 = 7
''' 

count = 0

for a in range(0, 8):
    for b in range(0, 8):
        for c in range(0, 8):
            for d in range(0, 8):
                if a + b + c + d == 7:
                    print(a, b, c, d)
                    count += 1

print("number of solution:", count)
