package BOJ.Sliver.Sliver2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2630_»öÁ¾ÀÌ {
	static int blue = 0;
	static int white = 0;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		int sum = 0;
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum += map[i][j];
			}
		}
		if(sum==0) white++;
		else if(sum==N*N/4) blue++;
		else cut(N, 0, 0);

		System.out.println(white);
		System.out.println(blue);
		
	}
	static void cut(int N, int x, int y) {
		int[] dx= {x, x, N/2+x, N/2+x};
		int[] dy = {y, N/2+y, y, N/2+y};
		
		
		for(int d=0;d<4;d++) {
			int sum = 0;
			for(int i=dx[d];i<N/2 + dx[d];i++) {
				for(int j=dy[d];j<N/2 + dy[d];j++) {
					sum+=map[i][j];
				}
			}
			if(sum==0) {
				white++;
			}
			else if(sum==N*N/4) {
				blue++;
			}
			else cut(N/2, dx[d], dy[d]);
		}

	}
}