package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2096_내려가기_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[][] arr = new int[n+1][3];
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] max_dp = new int[n+1][3];
		int[][] min_dp = new int[n+1][3];
		
		for(int i = 1; i <= n; i++) {
			max_dp[i][0] = Math.max(max_dp[i-1][0], max_dp[i-1][1]) + arr[i][0];
			max_dp[i][1] = Math.max(Math.max(max_dp[i-1][0], max_dp[i-1][1]), max_dp[i-1][2]) + arr[i][1];
			max_dp[i][2] = Math.max(max_dp[i-1][1], max_dp[i-1][2]) + arr[i][2];
			min_dp[i][0] = Math.min(min_dp[i-1][0], min_dp[i-1][1]) + arr[i][0];
			min_dp[i][1] = Math.min(Math.min(min_dp[i-1][0], min_dp[i-1][1]), min_dp[i-1][2]) + arr[i][1];
			min_dp[i][2] = Math.min(min_dp[i-1][1], min_dp[i-1][2]) + arr[i][2];
		}
		
		int max = Arrays.stream(max_dp[n]).max().getAsInt();
		int min = Arrays.stream(min_dp[n]).min().getAsInt();
		System.out.println(max + " " + min);
	}
}
