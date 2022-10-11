package boj;

import java.io.*;
import java.util.*;

public class Main_S1_9205_맥주마시면서걸어가기 {
	static boolean[] visited;
	
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] map, coor;
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n+2][n+2];
			
			// 방문체크 배열
			visited = new boolean[n+2];
			
			// 좌표들 배열
			coor = new int[n+2][n+2];
			for(int k = 0; k < n+2; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				coor[k] = new int[] {x, y};
				
				for(int i = 0; i < k; i++) {
					map[i][k] = map[k][i] = Math.abs(coor[k][0] - coor[i][0]) + Math.abs(coor[k][1] - coor[i][1]); // k와 i번째 좌표 거리 계산
				}
			}
			
			if(bfs(map, 0)) System.out.println("happy");
			else System.out.println("sad");
		}
	}
	
	static boolean bfs(int[][] map, int col) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.offer(col);
		visited[col] = true;
		
		while(!queue.isEmpty()) {
			col = queue.poll();
			
			if(col == n+1) {
				return true;
			}
			
			for(int k = 0; k < n+2; k++) {
				int nc = k;
				
				if(nc == col || visited[nc] || map[col][nc] > 1000) continue;
				
				queue.offer(nc);
				visited[col] = true;
			}
		}
		
		return false;
	}
}
