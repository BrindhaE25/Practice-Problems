"""

g           s
 e         k
  e       e
   k     e
    s   g
     f r
      o
     f r
    s   g
   k     e
  e       e
 e         k
g           s
"""
import sys
import math

st = "geeksforgeeks"

length = len(st)


for i in range(math.ceil(length/2)-1):
	print('%*s' %(i+1,st[i]),end= '')
	print('%*s' %((length-i-(i+1)),st[length-i-1]))
print('%*s' %(int(length/2)+1,st[int(length/2)]))

for i in range(math.floor(length/2)-1,-1,-1):
	print('%*s' %(i+1,st[i]),end= '')
	print('%*s' %((length-i-(i+1)),st[length-i-1]))
