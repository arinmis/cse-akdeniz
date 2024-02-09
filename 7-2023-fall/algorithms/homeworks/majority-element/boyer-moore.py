def majority_element(nums):
    for x in nums:
        print(f"{x} is  majority {isMajority(nums, x)}")
    m = -1
    count = 1
    for num in nums:
        if not num == m:
            count -= 1
            if count == 0:
                m = num
                count = 1
        else:
            count += 1
    return m
