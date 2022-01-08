""" 
list 7-bit ASCII digits 
with even and odd parity
"""

digits = [
            "0110000",
            "0110001",
            "0110010",
            "0110011",
            "0110100",
            "0110101",
            "0110110",
            "0110111",
            "0111000",
            "0111001",
        ]


def count_ones(binaryStr):
    count = 0
    for i in binaryStr:
        if i == "1":
            count += 1
    return count

def make_odd_parity(binaryStr):
    ones_amount = count_ones(binaryStr)
    if (ones_amount % 2 == 0):
        return "1" + binaryStr
    return "0" + binaryStr

def make_even_parity(binaryStr):
    ones_amount = count_ones(binaryStr)
    if (ones_amount % 2 == 1):
        return "1" + binaryStr
    return "0" + binaryStr

print('odd parities: ')
for digit in digits:
    print(make_odd_parity(digit))

print('\neven parities: ')
for digit in digits:
    print(make_even_parity(digit))
