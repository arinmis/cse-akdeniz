"""
Author: Mustafa Arinmis, 20190808004
Date: 2023-10-17
"""
from math import ceil

def merge(arr1, arr2):
    i = 0
    j = 0
    sorted_arr = [] 
    for _ in range(len(arr1) + len(arr2)):
        # merge if one of the array has completed
        if i >= len(arr1):
            sorted_arr += arr2[j:]
            break
        if j >= len(arr2):
            sorted_arr += arr1[i:]
            break

        if arr1[i] <= arr2[j]:
            sorted_arr.append(arr1[i])
            i += 1
        else:
            sorted_arr.append(arr2[j])
            j += 1
    return sorted_arr

def merge_sort(array):
    if len(array) <= 2:
        return array
    
    piece_size = ceil(len(array) / 3)
    left_array = merge_sort(array[:piece_size])
    mid_array = merge_sort(array[piece_size:2 * piece_size])
    right_array = merge_sort(array[2 * piece_size:])

    return merge(merge(left_array, mid_array), right_array)

arr = [1, 3, -1, 2, 10, 6, 5, 4, 7]
arr_sorted = merge_sort(arr)
print("array unsorted: ", arr)
print("array sorted: ", arr_sorted)

