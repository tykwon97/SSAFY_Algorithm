package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

	static int N;
	static int[][] map;
	static int[][] student;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N+1][N+1];
		student = new int[N*N+1][4];
		for(int i=1;i<N*N+1;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for(int j=0;j<4;j++) {
				student[n][j] = Integer.parseInt(st.nextToken());
			}
			position(n);
			for(int x=1;x<N+1;x++) {
				for(int y=1;y<N+1;y++) {
					System.out.print(map[x][y] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		int ans = 0;
		int[] score = {0, 1, 10, 100, 1000};
		for(int x=1;x<N+1;x++) {
			for(int y=1;y<N+1;y++) {
				int[] dx = {-1, 1, 0, 0};
				int[] dy = {0, 0, -1, 1};
				int n = map[x][y];
				int cnt = 0;
				for(int i=0;i<4;i++) {
					int nx = x + dx[i];
					int ny = y+ dy[i];
					if(nx<1||ny<1||nx>N||ny>N) continue;
					
					for(int j=0;j<4;j++) {
						if(map[nx][ny]==student[n][j]) cnt++;
					}
				}
				ans += score[cnt];
			}
		}
		System.out.println(ans);
	}
	
	static void position(int n) {
		int maxLike = 0;
		int zero = 0;
		int pX=-1;
		int pY=-1;
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		for(int x=1;x<N+1;x++) {
			for(int y=1;y<N+1;y++) {
				if(map[x][y]>0) continue;
				
				int cntLike = 0;
				int cntZero = 0;
				for(int i=0;i<4;i++) {
					int nx = x + dx[i];
					int ny = y+ dy[i];
					if(nx<1||ny<1||nx>N||ny>N) continue;
					
					if(map[nx][ny]==0) cntZero++;
					else {
						for(int j=0;j<4;j++) {
							if(map[nx][ny]==student[n][j]) cntLike++;
						}
					}
				}
				if(pX==-1&&pY==-1) {
					pX=x;
					pY=y;
				}
				if(maxLike<cntLike) {
					maxLike = cntLike;
					zero = cntZero;
					pX = x;
					pY = y;
				} else if(maxLike==cntLike&&zero<cntZero) {
					zero = cntZero;
					pX = x;
					pY = y;
				}
			}
		}
		map[pX][pY] = n;
	}
}
