# return number index blocked size to get nice UI 
def get_index(number, size):
    block_size = size 
    index = str(number)
    space_needed = block_size - len(str(number))
    for _ in range(space_needed): 
        index  = " " + index 
    return index 
        
# create given length of gray code
def generate_gray(codes, bit_len):
    if bit_len == 0:
        return codes

    # 1 bit gray code
    if len(codes) == 0:
        codes.append("0")
        codes.append("1")
    else:
        for i in range(len(codes) - 1, -1, -1):
            codes.append("1" + codes[i])
            codes[i] = "0" + codes[i]

    return generate_gray(codes, bit_len - 1)

bit_len = int(input('Enter number of bit for gray code: '))
gray_code = generate_gray([], bit_len)

# to get good looking index
# blocked chars for index values
blocked = len(str(2 ** bit_len - 1))

print("___Gray Codes:___\n")
for i in range(len(gray_code)):
    print(get_index(i + 1, blocked) + "th -> " + str(gray_code[i]))


