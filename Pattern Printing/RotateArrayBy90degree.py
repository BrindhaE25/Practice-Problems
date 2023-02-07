""" Rotate the array by 90 degree
Example: array = [ 1,2,3
	              4,5,6
	              7,8,9 ]
Then the output should be [ 3,6,9
			    2,5,8
			    1,4,7 ]"""
arr = [[1,2,3],[4,5,6],[7,8,9]]

row = len(arr)
col = len(arr[0])

k = 0
res = [[0 for i in range(col)] for j in range(row)]

print(res)

for i in range((col-1),-1,-1):
	
	for j in range(row):
		res[k][j] = arr[j][i]
		print(res[k][j])
	k = k+1
print(res)
