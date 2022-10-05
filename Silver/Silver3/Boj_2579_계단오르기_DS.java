import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2579_계단오르기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] stairs = new int[N];
		int[][] dp = new int[N][2];
		for(int i=0;i<N;i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		dp[0][0] = stairs[0];
		dp[0][1] = 0;
		if(N>1) {
			dp[1][0] = stairs[0] + stairs[1];
			dp[1][1] = stairs[1];
			
			for(int i=2;i<N;i++) {
				dp[i][0] = dp[i-1][1] + stairs[i];
				dp[i][1] = Math.max(dp[i-2][0] + stairs[i],dp[i-2][1] + stairs[i]);
			}
		}
		System.out.println(Math.max(dp[N-1][0],dp[N-1][1]));
	}
}
