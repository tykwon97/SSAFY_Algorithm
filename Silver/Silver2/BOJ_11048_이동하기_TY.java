package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11048_Main {
	public static int N;
	public static int M;
	public static int[][] map;
	public static int[][] candy;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 사탕 초기화
		candy = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(candy[i], Integer.MIN_VALUE);
		}
		
		// 초기 값 저장
		candy[0][0] = map[0][0];
		
		System.out.println(dp(N-1,M-1));
	}

	private static int dp(int x, int y) {
		int up = Integer.MIN_VALUE; 
		int left = Integer.MIN_VALUE;
		int upleft = Integer.MIN_VALUE;
		
		if(candy[x][y] != Integer.MIN_VALUE)
			return candy[x][y];
		
		if(x >= 1)
			up = dp(x-1,y); // 위에서 오는 경우
		if(y >= 1)
			left = dp(x,y-1); // 왼쪽에서 오는 경우
		if(x >= 1 && y>= 1)
			upleft = dp(x-1,y-1); //대각선에서 오는 경우
		
		int temp; // 현재 위치로 넘어오는 방법 중 최대 사탕 개수
		temp = Math.max(up, left);
		temp = Math.max(temp, upleft);
		
		return candy[x][y] = temp +map[x][y];
	}
}