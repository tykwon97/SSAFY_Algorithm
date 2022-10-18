package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_1012_유기농배추 {
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static int rows, cols, K;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			cols = Integer.parseInt(st.nextToken());
			rows = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[rows][cols];
			visited = new boolean[rows][cols];
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());
				map[row][col] = 1;
			}
			
			int index = 0;
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < cols; j++) {
					if(map[i][j] == 1 && !visited[i][j]) { // 배추가 있는데, 방문하지 않았다!
						bfs(i, j);
						index++;
					}
				}
			}
			
			sb.append(index).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int row, int col) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] {row, col});
		visited[row][col] = true;
		
		while(!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			row = cur[0];
			col = cur[1];
			
			for(int k = 0; k < 4; k++) {
				int nr = row + dr[k];
				int nc = col + dc[k];
				
				if(nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc]) continue;
				
				if(map[nr][nc] == 1) {
					queue.offer(new Integer[] {nr, nc});
					visited[nr][nc] = true;
				}				
			}
		}
	}
}
