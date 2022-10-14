package boj.s3;

import java.io.*;

public class Main_S3_17626_FourSquares_DP {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		// 초기화
		for(int i = 1; i <= N; i++) {
			dp[i] = 4;
		}
		dp[1] = 1;
		
		// 자기 자신에서 가능한 제곱수들 뺀 나머지 dp배열 값을 비교해서 최소값..
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= Math.sqrt(i); j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		
		System.out.println(dp[N]);
	}
}
