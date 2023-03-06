package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_2096_내려가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int j=0;j<3;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] max_dp = new int[N][3];
		int[][] min_dp = new int[N][3];
		max_dp[0][0] = map[0][0];
		max_dp[0][1] = map[0][1];
		max_dp[0][2] = map[0][2];
		min_dp[0][0] = map[0][0];
		min_dp[0][1] = map[0][1];
		min_dp[0][2] = map[0][2];
		for(int i=1;i<N;i++) {
			max_dp[i][0] = Math.max(max_dp[i-1][0]+map[i][0], max_dp[i-1][1]+map[i][0]);
			max_dp[i][1] = Math.max(max_dp[i-1][2]+map[i][1], Math.max(max_dp[i-1][0]+map[i][1], max_dp[i-1][1]+map[i][1]));
			max_dp[i][2] = Math.max(max_dp[i-1][1]+map[i][2], max_dp[i-1][2]+map[i][2]);
			min_dp[i][0] = Math.min(min_dp[i-1][0]+map[i][0], min_dp[i-1][1]+map[i][0]);
			min_dp[i][1] = Math.min(min_dp[i-1][2]+map[i][1], Math.min(min_dp[i-1][0]+map[i][1], min_dp[i-1][1]+map[i][1]));
			min_dp[i][2] = Math.min(min_dp[i-1][1]+map[i][2], min_dp[i-1][2]+map[i][2]);
		}
		System.out.println(Math.max(max_dp[N-1][2], Math.max(max_dp[N-1][0], max_dp[N-1][1])) + " " + Math.min(min_dp[N-1][2], Math.min(min_dp[N-1][0], min_dp[N-1][1])));
	}
}
