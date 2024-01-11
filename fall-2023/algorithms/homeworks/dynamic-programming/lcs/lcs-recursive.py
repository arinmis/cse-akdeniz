def lcs(str1, str2, i, j):
    # print(str1[i:], str2[j:])
    if i >= len(str1) or j >= len(str2):
        return 0
    if str1[i] == str2[j]:
        return  1 + lcs(str1, str2, i + 1, j + 1)
    first_skipped = lcs(str1, str2, i + 1, j)
    second_skipped = lcs(str1, str2, i, j + 1)
    return max(first_skipped, second_skipped)


X = "AGGTAB"
Y = "GXTXAYB"
print(lcs(X, Y, 0, 0))
