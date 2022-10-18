package SSAFY_Algorithm.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11502_카드구매하기_DS {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] p = new int[N+1];
		for(int i=1;i<=N;i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = p[1];
		for(int i=2;i<=N;i++) {
			dp[i] = 0;
			for(int j=0;j<i;j++) {
				dp[i] = Math.max(dp[i], dp[j] + p[i-j]);
			}
		}
		System.out.println(dp[N]);
	}

}
