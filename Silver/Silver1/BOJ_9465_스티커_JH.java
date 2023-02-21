package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9465_스티커_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());  // 테케수
		for(int tc = 1; tc <= T; tc++) {
//			Arrays.fill(dp[0], 0);
//			Arrays.fill(dp[1], 0);
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] dp = new int[2][n+2];
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 2; j < n+2; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for(int i = 2; i < n+2; i++) {
				dp[0][i] = dp[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
				dp[1][i] = dp[1][i] + Math.max(dp[0][i-2], dp[0][i-1]);
			}
			
			int ans = Math.max(dp[0][n+1], dp[1][n+1]);
			
			System.out.println(ans);
			dp = null;
		}
	}
}
