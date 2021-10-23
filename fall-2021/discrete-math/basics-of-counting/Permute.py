'''
list all the selection of size 2
from list {1, 2, 3, 4, 5, 6}
'''

# print all possible way to choose from set in given length
def chooseAll(k, combination, digits, selecteds):
    for i in range(len(digits)):
        combination.add(digits[i])
        if k == 1:
            selecteds.add(frozenset(combination))
        else: 
            permute(k - 1, combination, digits[:i] + digits[i + 1:], selecteds)
        combination.remove(digits[i])


selecteds = set() 
combination = set()
chooseAll(3, combination, "123456", selecteds)
for item in selecteds:
    for i in item:
        print(i, end="")
    print()
