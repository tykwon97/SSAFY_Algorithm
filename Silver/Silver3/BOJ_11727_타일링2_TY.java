package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11727_Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(i==1) {
				dp[i] = 1;
				continue;
			}else if(i==2) {
				dp[i] = 3;
				continue;
			}
			dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
		}
		System.out.println(dp[N]);
	}
}
