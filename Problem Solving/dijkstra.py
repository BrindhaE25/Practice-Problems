import sys
class Graph:
	def __init__(self,vertices,graph):
		self.vertices = vertices
		self.value = [sys.maxsize] * self.vertices
		self.visited = [0] * self.vertices
		self.graph = graph
		#print(self.value, self.visited)
	def dijkstra(self,src,graph):
		#print(self.graph)
		self.value[src] = 0
		self.visited[src] = 1
		for row in range(self.vertices):
			#print(row)
			for col in range(self.vertices):
				#print(self.graph[row][col])
				if self.graph[row][col] > 0 and self.visited[col] == 0 and self.value[col] > self.value[row] + self.graph[row][col]:
					self.value[col] = self.value[row] + self.graph[row][col]
					#print(self.value[col])
					self.visited[col] = 1
	def printgraph(self):
		for i in self.value:
			print(i)


if __name__ =="__main__":
	graph = [[0,4,0,0,0,0,0,8,0],
			[4,0,8,0,0,0,0,11,0],
			[0,8,0,7,0,4,0,0,2],
			[0,0,7,0,9,14,0,0,0],
			[0,0,0,9,0,10,0,0,0],
			[0,0,4,14,10,0,2,0,0],
			[0,0,0,0,0,2,0,1,6],
			[8,11,0,0,0,0,1,0,7],
			[0,0,2,0,0,0,6,7,0]]
	#print(graph)
	g= Graph(9,graph)
	g.dijkstra(0,graph)
	g.printgraph()