import random 


# 0 1 2   3 4 5    6 7 8
# c a t + d o g  = p i g 
def findSum(a):
	# control
	if 100 * (a[0] + a[3]) + 10 * (a[1] + a[4]) + 1 * (a[2] + a[5]) == 100 * (a[6]) + 10 * (a[7]) + 1 * (a[8]):
		return a
	
	# update data
	a[0] = random.randint(0, 9) 
	a[1] = random.randint(0, 9) 
	a[2] = random.randint(0, 9) 
	a[3] = random.randint(0, 9) 
	a[4] = random.randint(0, 9) 
	a[5] = random.randint(0, 9) 
	a[6] = random.randint(0, 9) 
	a[7] = random.randint(0, 9) 
	a[8] = random.randint(0, 9) 

	# call recursively
	return findSum(a)

def getUnique(arr):
	while True:
		result = findSum(arr)
		if len(result) == len(set(result)):
			return result

arr = [0, 1, 2, 3, 4, 5, 6, 7, 8]
result = findSum(arr)
print(str(result[0]) + str(result[1]) + str(result[2]) 
		+ " + " +  
	str(result[3]) + str(result[4]) + str(result[5]) 
		+ " = " +  
	str(result[6]) + str(result[7]) + str(result[8]) 
	)


