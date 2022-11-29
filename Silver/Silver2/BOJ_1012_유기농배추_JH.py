from collections import deque
T = int(input())    # TC수
for tc in range(T):
    row, col, pos = map(int, input().split())    # 가로, 세로, 배추위치
    lst = [list(map(int, input().split())) for _ in range(pos)]    # 배추위치 배열
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]    # 방향벡터
    queue = deque()
    visited = [[0 for _ in range(col)] for i in range(row)]    # 배추밭 방문체크
    cnt = 0    # 배추흰지렁이 수
    # for x, y in lst:    # 배추를 심은곳만
    for x, y in lst:
        if visited[x][y]:    # 방문된곳이면 지나치고
            continue
        else:
            queue.append((x, y))
            visited[x][y] = 1  # 꼭 해주기
            while queue:    # 큐가 차있는동안
                x, y = queue.pop()
                for i in range(4):
                    nx = x + dx[i]
                    ny = y + dy[i]
                    if 0 <= nx < row and 0 <= ny < col and visited[nx][ny] == 0 and [nx, ny] in lst:    # 방문x & 이어짐 & 범위안에 있음
                        queue.append((nx, ny))    # 큐에 넣어주고
                        visited[nx][ny] = 1    # 방문체크
            cnt += 1
    print(cnt)