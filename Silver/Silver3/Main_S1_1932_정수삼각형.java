package algorithm;

import java.io.*;
import java.util.*;

public class Main_S1_1932_정수삼각형 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j <= i; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			for(int j = i+1; j < n; j++) {
				arr[i][j] = 0;
			}
		}
		
		int[][] dp = new int[n][n];
		dp[0][0] = arr[0][0];
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(j == 0) dp[i][j] = dp[i-1][j] + arr[i][j];
				else if(j == n-1) dp[i][j] = dp[i-1][j-1] + arr[i][j];
				else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
			}
		}
		
		int maxVal = 0;
		for(int i = 0; i < n; i++) {
			maxVal = maxVal > dp[n-1][i] ? maxVal : dp[n-1][i];
		}
		
		System.out.println(maxVal);
	}
}
