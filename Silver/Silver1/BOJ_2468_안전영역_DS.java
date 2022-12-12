package baekjoon.sliver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {

	static int[][] map;
	static int N;
	static class point {
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		int maxH = 0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		int region = 1;
		for(int h=1;h<maxH;h++) {
			rain(h);
			region = Math.max(region,cntRegion());
		}
		System.out.println(region);
	}
	
	private static void rain(int h) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]<=h) { 
					map[i][j] = 0;
				}
			}
		}
	}
	
	private static int cntRegion() {
		int cnt = 0;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {1, -1, 0, 0};
		boolean[][] isVisited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>0 && !isVisited[i][j]) {
					cnt++;
					Queue<point> q = new LinkedList<point>();
					q.add(new point(i, j));
					isVisited[i][j] = true;
					while(!q.isEmpty()) {
						point p = q.poll();
						int x = p.x;
						int y = p.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx<0||ny<0||nx>=N||ny>=N||map[nx][ny]==0||isVisited[nx][ny]) continue;
							
							q.add(new point(nx, ny));
							isVisited[nx][ny] = true;
						}
					}
				}
			}
		}
		return cnt;
	}
}
