count = 0
n = 10
for i in range(1, n + 1):
    for j in range(1, i + 1):
        for k in range(1, j + 1):
            count += 1

print(count)
