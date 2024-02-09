# sorted up to j
array = [-4, 1, 2, 5, 12, -3, 8, 10]

print("unsorted ", array)

# swap given two index of the array
def swap_items(array, i, j):
    copy_array = array.copy()
    temp = copy_array.pop(j)
    copy_array.insert(i, temp)
    return copy_array

# put selected index into sorted place
def put_into_correct_loc(array, j):
    copy_array = array.copy()
    for i in range(j):
        if copy_array[j] < copy_array[i]: 
            return swap_items(copy_array, i, j)
    return copy_array



for i in range(1, len(array)):
    array = put_into_correct_loc(array, i)

print("sorted: ", array)
            



