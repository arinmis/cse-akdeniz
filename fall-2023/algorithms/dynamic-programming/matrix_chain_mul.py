def print_matrix(m):
    for row in m:
        print(row)

def matrix_chain_mul(p):
    n = len(p) - 1
    m = [[0] * n for _ in range(n)]  # store costs
    s = [[0] * n for _ in range(n)]  # parentheses positions
    for l in range(2, n + 1):
        for i in range(n - l + 1):
            j = i + l - 1
            m[i][j] = float("inf")
            for k in range(i, j):
                q = m[i][k] + m[k + 1][j] + p[i] * p[k + 1] * p[j + 1]
                if q < m[i][j]:
                    m[i][j] = q
                    s[i][j] = k
    return m, s


def print_optimal_parentheses(s, i, j):
    if i == j:
        print(f" A{i + 1} ", end="")
    else:
        print("(", end="")
        print_optimal_parentheses(s, i, s[i][j])
        print_optimal_parentheses(s, s[i][j] + 1, j)
        print(")", end="")


p = [30, 35, 15, 5, 10, 20, 25]
for i in range(len(p) - 1):
    print(f"A{i + 1}: {p[i]}x{p[i + 1]}")


m, s = matrix_chain_mul(p)
print_optimal_parentheses(s, 0, 5)


print()
