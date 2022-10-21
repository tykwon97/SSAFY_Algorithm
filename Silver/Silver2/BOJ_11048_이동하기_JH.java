package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기_JH {

	static int N, M;
	static int ans = 0;
	static int[][] map;
	static int[][] visited;
	
	static int[] dx = {1, 0, 1};
	static int[] dy = {0, 1, 1};
	
//	public static class Point {
//		int x;
//		int y;
//		public Point(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new int[N+1][M+1];
        for(int i = 0; i <= N; i++){
            for(int j = 0; j <= M; j++)
                visited[i][j] = -1;
        }
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);  // 시작점
		queue.add(1);  // 시작점
		visited[1][1] = map[1][1];
		while(!queue.isEmpty()) {  // 큐가 비어있지않는동안
			int x = queue.poll();
			int y = queue.poll();
			for(int i = 0; i < 3; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx > 0 && nx <= N && ny > 0 && ny <= M) {  // 바운더리
					int sum = visited[x][y] + map[nx][ny];
					if(sum > visited[nx][ny]) {
						queue.add(nx);
						queue.add(ny);
						visited[nx][ny] = sum;
					}
				} 
			}
		}
		
		System.out.println(visited[N][M]);
	}
}
