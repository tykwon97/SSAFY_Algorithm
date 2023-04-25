import math
N = int(input())
dp = [1e9 for _ in range(N+1)]
dp[0] = 0
dp[1] = 1
for i in range(2, N+1):
    if (math.sqrt(i) % 1) != 0:  # 제곱수가 아니면
        for j in range(1, int(math.sqrt(i))+1):
            dp[i] = min(dp[i], dp[i-j**2]+1)  # 제곱수를 뺀 값의 dp값에서 1더한값과 현재 dp값 중 작은 걸로 갱신해감
    else:  # 제곱수면 1로 설정
        dp[i] = 1
print(dp[N])


# 배열을 만들어서 제곱수의 개수에 따라 1씩 더해줌
# dp[0] = 0 설정해주고 j 범위에서 마지막에 +1해주기