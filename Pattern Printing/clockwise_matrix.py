"""
Example : arr = [  1, 2, 3, 4
		   5, 6, 7, 8
		   9,10,11,12
		  13,14,15,16]
Output : [ 5,  1,  2,  3, 
	   9, 10,  6,  4
	   13, 11, 7,  8
	   14, 15, 16, 12]
"""
arr = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]

row = len(arr)
col = len(arr[0])
print(row,col)
k = l = 0
prev = curr = 0

while( k < row and l < col):
	prev = arr[k][k]
	for i in range(k,col):
		curr = arr[k][i]
		arr[k][i] = prev
		prev = curr
	k = k+1
	for i in range(k,row):
		curr = arr[i][col-1]
		arr[i][col-1] = prev
		prev = curr
	col = col -1
	for i in range(col-1,l-1,-1):
		curr = arr[row-1][i]
		arr[row-1][i] = prev
		prev = curr
	row = row -1
	for i in range(row-1,k-1,-1):
		curr = arr[i][l]
		arr[i][l] = prev
		prev = curr
	l = l+1
	arr[k-1][l-1] = prev

print(arr)



