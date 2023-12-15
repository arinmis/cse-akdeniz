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
    if len(array) <= 1:
        return array
    
    border = ceil(len(array) / 2)
    left_array = merge_sort(array[:border])
    right_array = merge_sort(array[border:])

    return merge(left_array, right_array)

arr = [1, 3, -1, 2, 10]
arr_sorted = merge_sort(arr)
print("array unsorted: ", arr)
print("array sorted: ", arr_sorted)

