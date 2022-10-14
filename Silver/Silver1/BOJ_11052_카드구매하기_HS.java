package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_11052_카드구매하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] P = new int[N + 1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		dp[1] = P[1];
		for(int i = 2; i <= N; i++) {
			dp[i] = P[i];
			for(int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);				
			}
		}
		
		System.out.println(dp[N]);
	}
}
