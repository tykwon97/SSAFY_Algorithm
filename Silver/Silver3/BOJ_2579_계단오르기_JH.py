def fun():
    for i in range(10):
        if ord(q[l1])-ord(p[l1]) > 1:
            return "Y"
        elif l1 == l2:    # 같은경우
            if ord(q[l1])-ord(p[l1]) <= 1 or ord(q[l1])-ord(p[l1])==65:
                print("l")
                return "N"
            else:
                return "Y"
        elif l2-l1 > 1:    # 두자리 이상 차이나는 경우
            return "Y"
        elif ord(q[l2])-ord(p[l2]) == 65:
            return "N"


T = int(input())
for tc in range(1, T+1):
    p, q = input(), input()
    l1 = len(p)-1
    l2 = len(q)-1
    p = p + " " * (10-len(p))
    q = q + " " * (10-len(q))
    print(fun())

