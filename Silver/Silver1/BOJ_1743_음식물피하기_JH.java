package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기_JH {

static int[] dx = {0, 0, -1, 1};
static int[] dy = {-1, 1, 0, 0};
public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    st = new StringTokenizer(br.readLine());
    int N, M, K;
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    
    int[][] arr = new int[N+1][M+1];
    boolean[][] visited = new boolean[N+1][M+1];
    
    for(int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        arr[x][y] = 1;
    }
    
    int ans = Integer.MIN_VALUE;
    Queue<int[]> queue = new ArrayDeque<>();
    for(int i = 1; i < N+1; i++) {
        for(int j = 1; j < M+1; j++) {
            int cnt = 0;
            if(!visited[i][j] && arr[i][j] == 1) {
                queue.add(new int[] {i, j});
                cnt++;
                visited[i][j] = true;
            }
            while(!queue.isEmpty()) {
                int[] arr2 = queue.poll();
                int x = arr2[0];
                int y = arr2[1];
                for(int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(nx > 0 && nx < N+1 && ny > 0 && ny < M+1 && !visited[nx][ny] && arr[nx][ny]==1) {
                        queue.add(new int[] {nx, ny});
                        cnt++;
                        visited[nx][ny] = true;
                    }
                }
            }
            if(ans < cnt) {
                ans = cnt;
            }
        }
    }
    
    System.out.println(ans);
}
}
