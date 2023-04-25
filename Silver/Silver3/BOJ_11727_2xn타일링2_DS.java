package BOJ.Sliver.Sliver3;

import java.io.*;


public class BOJ_11727_2xnÅ¸ÀÏ¸µ2 {

	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		int[] dp = new int[N+1];
		dp[1] = 1;
		if(N>1) dp[2] = 3;

		for (int i = 3; i <= N; i++) {
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[N]);
		
	}

}
