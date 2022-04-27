class Graph:
	graph = []
	vertices_no = 0
	vertices = []
	def AddVertex(self,vertex):
		self.vertices_no += 1
		self.vertices.append(vertex)
		if self.vertices_no > 1:
			for v in self.graph:
				v.append(0)
		temp = []
		for i in range(self.vertices_no):
			temp.append(0)
		self.graph.append(temp)
	def AddEdges(self,v1,v2,val):
		idx1 = self.vertices.index(v1)
		idx2 = self.vertices.index(v2)
		self.graph[idx1][idx2] = val
	def PrintVertices(self):
		for vertex in self.graph:
			print(vertex)



if __name__ == "__main__":
	g = Graph()
	for i in range(1,11):
		g.AddVertex(i)
	val = int(input())
	while val != 0:
		v1,v2 = input("Enter the vertics:").split( )
		v1 = int(v1)
		v2 = int(v2)
		g.AddEdges(v1,v2,val)
		val = int(input("Enter the value:"))
	
	g.PrintVertices()