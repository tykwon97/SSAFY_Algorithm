package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1012_유기농배추_SK {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1}; // 동남서북
	static int[] dc = {1, 0, -1, 0};
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int row = 0, col = 0;
			map = new int[N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				col = Integer.parseInt(st.nextToken());
				row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) continue;
					bfs(i, j);
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
			
		}
		
		System.out.println(sb.toString());
		
	}

	private static void bfs(int i, int j) {
		dq = new ArrayDeque<>();
		
		dq.add(new int[] {i, j});
		map[i][j] = 0;
		
		while (!dq.isEmpty()) {
			int[] cur = dq.poll();
			
			int nextR=0, nextC=0;
			for (int r = 0; r < 4; r++) {
				nextR = cur[0] + dr[r];
				nextC = cur[1] + dc[r];
				if (0<=nextR && nextR<N && 0<=nextC && nextC<M && map[nextR][nextC]==1) {
					dq.add(new int[] {nextR, nextC});
					map[nextR][nextC] = 0;
				}
			}
		}
		
	}

}
