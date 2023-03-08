package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9461_파도반수열_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] dp = new int[100];
		for(int tc = 1; tc <= T; tc++) {
			Arrays.fill(dp, 0);
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			dp[4] = 2;
			dp[5] = 2;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n <= 5) {
				System.out.println(dp[n]);
			} else {
				for(int i = 6; i <= n; i++) {
					dp[i] = dp[i-1] + dp[i-5];
				}
				System.out.println(dp[n]);
			}
		}
	}
}
