package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1309_동물원 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[][] dp = new int[N][2];
		dp[0][0] = 2;
		dp[0][1] = 3;

		for(int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1]) % 9901;
		}

		System.out.println(dp[N-1][1]);
	}
}
