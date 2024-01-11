def print_table(table):
    for row in table:
        print(row)

def print_lcs(str1, table, row, col):
    if row == 0 or col == 0:
        return
    if table[row][col] > table[row - 1][col - 1]:
        print_lcs(str1, table, row - 1, col - 1)
        print(str1[col - 1], end="")
    elif table[row - 1][col] > table[row][col - 1]:
        print_lcs(str1, table, row - 1, col)
    else:
        print_lcs(str1, table, row, col - 1)

def gen_lcs_table(str1, str2):
    n = len(str1) + 1
    m = len(str2) + 1
    table = [[0] * n for _ in range(m)]
    for row in range(1, m):
        for col in range(1, n):
            if str1[col - 1] == str2[row - 1]:
                table[row][col] = table[row - 1][col - 1] + 1
            else:
                table[row][col] = max(table[row - 1][col], table[row][col - 1])
    return table

X = "AGGTAB"
Y = "GXTXAYB"

lcs_table = gen_lcs_table(X, Y)
print(f"lcs lenght is {lcs_table[-1][-1]}")
print_lcs(X, lcs_table, len(lcs_table) - 1, len(lcs_table[0]) - 1)
print()
# print_table(lcs_table)
