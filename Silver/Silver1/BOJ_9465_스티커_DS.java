package BOJ.Sliver.Sliver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9465_½ºÆ¼Ä¿ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int tc = 0 ; tc<T;tc++) {
		
			int n = Integer.parseInt(in.readLine());
			int[][] sticker = new int[2][n];

			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				for(int j=0;j<n;j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][n];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			if(n>1) {
				dp[1][1] = sticker[1][1] + sticker[0][0];
				dp[0][1] = sticker[0][1] + sticker[1][0];

				for(int i=2;i<n;i++) {
					dp[0][i] = Math.max(Math.max(dp[1][i-1]+sticker[0][i], dp[0][i-2]+sticker[0][i]),dp[1][i-2]+sticker[0][i]);
					dp[1][i] = Math.max(Math.max(dp[0][i-1]+sticker[1][i], dp[1][i-2]+sticker[1][i]), dp[0][i-2]+sticker[1][i]);
				}
			}


			System.out.println(Math.max(dp[0][n-1], dp[1][n-1]));
		}
	}

}
