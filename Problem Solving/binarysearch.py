class BinarySearch:
	array = []
	def __init__(self,arr):
		self.array = arr

	def search(self,val):
		low = 0
		high = len(self.array) - 1
		mid = int((low + high) / 2)
		while(low <= high):
			if(val > self.array[mid]):
				low=mid +1
			elif(val < self.array[mid]):
				high = mid-1
			elif(val == self.array[mid]):
				return mid+1
			mid = int((low+high) / 2)
		return -1




class Search:
	if __name__ == "__main__":
		arr = [10,20,25,30,35,40,45,50,55,60,70,80,90,100]
		bs = BinarySearch(arr)
		idx = bs.search(500)
		print(idx)
