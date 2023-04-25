import sys
from itertools import permutations
temp=sys.stdin.readline().split(" ")
N=int(temp[0])
M=int(temp[1])
temp=sys.stdin.readline().split(" ")
number=list(map(int, temp))
number.sort()
combi=list(permutations(number, M))
combi=sorted(list(set(combi)))
for c in combi:
    for num in c:
        print(num, end=" ")
    print()
