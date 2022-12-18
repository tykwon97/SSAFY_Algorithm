import sys
from itertools import permutations
temp=sys.stdin.readline().split(" ")
N=int(temp[0])
M=int(temp[1])
temp=sys.stdin.readline().split(" ")
number=list(map(int, temp))
number.sort()
combi=list(permutations(number, M))
combi_arr=[]
for c in combi:
    c=list(c)
    combi_arr.append(c)
for c in combi_arr:
    c=list(map(str, c))
    print(" ".join(c))
