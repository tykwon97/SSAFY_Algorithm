package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_점프_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n][n];
		long[][] dp = new long[n][n];	

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int size = arr[i][j];
				if(i==n-1 && j==n-1)
					continue;
				if((i+size)<n)  // 범위 내에 있고 목적지는 아닐때
					dp[i+size][j] += dp[i][j];  // 현재 지점까지의 경로수
				if((j+size)<n)  // 범위 내에 있고 목적지는 아닐때
					dp[i][j+size] += dp[i][j];	// 현재 지점까지의 경로수			
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(dp[i][j]+" ");
//			}System.out.println();
//		}
		
		System.out.println(dp[n-1][n-1]);
	}
}
