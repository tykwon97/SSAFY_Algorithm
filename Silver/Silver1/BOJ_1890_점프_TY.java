package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1890_Main {
	
	public static int N;
	public static int[][] map;
	public static long[][] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		
		map = new int[N][N];
		isVisited = new long[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long result = jump(0,0);
		
		System.out.println(result);
	}

	private static long jump(int x, int y) {
			int jumpCount = map[x][y];
			
			if(x == N-1 && y == N-1) 
				return 1;
			if(map[x][y] == 0)
				return 0;
			
			if(isVisited[x][y]>0)
				return isVisited[x][y];
			
			long cnt = 0;
			if(x+jumpCount < N) 
				cnt += jump(x+jumpCount,y);
			if(y+jumpCount < N) 
				cnt += jump(x,y+jumpCount);
			
			isVisited[x][y] = cnt;
			return cnt;
	}
}
