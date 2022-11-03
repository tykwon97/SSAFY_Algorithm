package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역_SK_s1 {
	
	static int N, map[][];
	static boolean[][] visited;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int maxA;
	static Deque<int[]> dq;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int minH = 101;
		int maxH = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		
		for (int i = minH-1; i < maxH; i++) {
			bfs(i);
		}
		System.out.println(maxA);
		
	}
	
	private static void bfs(int height) {
		dq = new ArrayDeque<int[]>();
		visited = new boolean[N][N];
		
		int tempCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || map[i][j]<=height) continue;
				dq.add(new int[] {i, j});
				visited[i][j] = true;
				tempCnt++;
				
				while (!dq.isEmpty()) {
					int[] cur = dq.poll();
					
					for (int c = 0; c < 4; c++) {
						int nextR = cur[0] + dr[c];
						int nextC = cur[1] + dc[c];
						if (0<=nextR && nextR<N && 0<=nextC && nextC<N &&
								map[nextR][nextC]>height && !visited[nextR][nextC]) {
							dq.add(new int[] {nextR, nextC});
							visited[nextR][nextC] = true;
						}
					}
					
				}
			}
		}
		
		maxA = Math.max(maxA, tempCnt);
	}

}
