def partition(arr, start, end):
    pivot = end
    i = start - 1
    for j in range(i + 1, end):
        if arr[j] < arr[pivot]:
            arr[j], arr[pivot] = arr[pivot], arr[j]
    # swap pivot
    arr[i + 1], arr[pivot] = arr[pivot], arr[i + 1]
    return i + 1


def quick_sort(arr, start, end):
    # array has one element, it is sorted
    print('this is array:', arr[start:end+1])
    if start >= end:
        return
    p = partition(arr, start, end)
    print("this is where we put pivot:", p)
    quick_sort(arr, 0, p - 1)
    quick_sort(arr, p + 1, end)




array = [12, 9, 7, 15, 10]

print("unsorted:", array)
quick_sort(array, 0, len(array) - 1)
print("sorted:", array)
