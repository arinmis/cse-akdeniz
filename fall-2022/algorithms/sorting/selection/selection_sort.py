'''
NOTE: psudo code array is zero indexed 
SELECTION_SORT(A)
    for i = 2 to A.length:            
        min = i                        
        for j = i + 1 to A.length:    
            if A[min] > A[j] 
                min = j
        swap A[i], A[min]
'''

def selection_sort(array):
    for i in range(1, len(array)):
        min_index = i
        for j in range(i + 1, len(array)):
            if array[min_index] > array[j]:
                min_index = j
        array[i], array[min_index] =  array[min_index], array[i]

array = [-1, 5, 4, 3, 1, 11]
selection_sort(array)
print(array)