package Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2636_치즈_DS {
	static int N, M, cnt, time=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] cheese = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<M;j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		while(cheeseCnt(cheese)!=0) {
			outline(cheese, 0, 0);
			cnt = 0;
			int n = cheeseCnt(cheese);
			cheese = melting(cheese);
			if(n==cnt) ans = cnt;
			time++;
		}
		System.out.println(time+"\n"+ans);
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(cheese[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	static int cheeseCnt(int[][] c) {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(c[i][j]==1) cnt++;
			}
		}
		return cnt;
	}
	static int[][] copyCheese(int[][] c) {
		int[][] nc = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				nc[i][j] = c[i][j];
			}
		}
		return nc;
	}
	static int[][] melting(int[][] cheese) {
		int[][] nc = copyCheese(cheese);
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(cheese[i][j]==1) {
					int[] dx = {1, -1, 0, 0};
					int[] dy = {0, 0, 1, -1};
					for(int r=0;r<4;r++) {
						int nx = i+dx[r];
						int ny = j+dy[r];
						if(nx<0||ny<0||nx>=N||ny>=M||cheese[nx][ny]==1||cheese[nx][ny]==0) continue;
						
						nc[i][j]=time+2;
						cnt++;
						break;
					}
				}
			}
		}
		return nc;
	}
	static void outline(int[][] cheese, int x, int y) {
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx<0||ny<0||nx>=N||ny>=M||cheese[nx][ny]==1||cheese[nx][ny]==time+2) continue;
			cheese[nx][ny] = time+2;
			outline(cheese, nx,ny);
		}
		
	}

}
