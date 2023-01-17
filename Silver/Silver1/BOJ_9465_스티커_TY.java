package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N9465_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(in.readLine());
			
			int[][] sticker = new int[2][N];
			int[][] dp = new int[2][N];

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(in.readLine()," ");
				for (int k = 0; k < N; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			
			for (int j = 1; j < N; j++) {
				if(j==1) {
					dp[0][1] = dp[1][0] + sticker[0][1];
					dp[1][1] = dp[0][0] + sticker[1][1];
					continue;
				}
				dp[0][j] = Math.max(dp[1][j-1]+sticker[0][j], Math.max(dp[0][j-2], dp[1][j-2])+sticker[0][j]);
				dp[1][j] = Math.max(dp[0][j-1]+sticker[1][j], Math.max(dp[0][j-2], dp[1][j-2])+sticker[1][j]);
			}
			
			int prevValue = (N==1 ? 0 : Math.max(dp[0][N-2], dp[1][N-2]));
			int lastValue = Math.max(dp[0][N-1], dp[1][N-1]);
			int maxValue = Math.max(prevValue, lastValue);
			
			sb.append(maxValue).append("\n");
		}

		System.out.println(sb);	
	}
}
