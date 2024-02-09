class PriorityQueue:
    A = [16, 14, 10, 8, 7, 9, 3, 2, 4, 1]
    
    def __init__(self):
        # self.heapify(0)
        pass

    def heapify(self, i):
        largest = i
        left_index =  2 * i + 1
        right_index =  2 * i + 2
        if left_index <= len(self.A) - 1 and self.A[left_index] > self.A[i]:
            largest = 2 * i + 1
        if right_index <= len(self.A) - 1 and self.A[right_index] > self.A[largest]:
            largest = 2 * i + 2
        if not largest == i:
            self.A[i], self.A[largest] = self.A[largest], self.A[i]
            self.heapify(largest)

    def heap_insert(self, key):
        self.A.append(key)
        i = len(self.A) - 1
        while i > 0 and self.A[i // 2] < key:
            parent_index = (i - 1) // 2
            self.A[i] = self.A[parent_index]
            i = parent_index
        self.A[i] = key

    def extract_max(self):
        max_value = self.A[0]
        self.A[0] = self.A[len(self.A) - 1]
        self.A.pop()
        self.heapify(0)
        return max_value

    def heap_increase_key(self, i, key):
        if key < self.A[i]:
            raise Error(f"key {key} must be last than {self.A[i]}") 
        while i > 0 and self.A[i // 2] < key:
            parent_index = (i - 1) // 2
            self.A[i] = self.A[parent_index]
            i = parent_index
        self.A[i] = key

    def print_heap(self, index=0, indent=0):
        # Base case: if the current index is beyond the length of the heap, return
        if index >= len(self.A):
            return
        left = 2 * index + 1
        right = 2 * index + 2
        if right < len(self.A):
            self.print_heap(right, indent + 4)
        print(' ' * indent, self.A[index])
        if left < len(self.A):
            self.print_heap(left, indent + 4)

    def __repr__(self):
        return f"{self.A}"

dash_amount = 30
p_queue = PriorityQueue() 
p_queue.print_heap()
print("-" * dash_amount)
p_queue.heap_increase_key(8, 15)
p_queue.print_heap()
print("-" * dash_amount)
p_queue.heap_insert(19)
p_queue.print_heap()
print("-" * dash_amount)
p_queue.print_heap()

