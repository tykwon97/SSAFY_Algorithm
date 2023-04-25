package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11727_타일링2_JH {

	static int n, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int[] dp = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i < n+1; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2]) % 10007;
		}
		System.out.println(dp[n]);
	}
}
