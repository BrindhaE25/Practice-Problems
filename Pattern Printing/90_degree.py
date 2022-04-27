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