package Silver.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17626_FourSquares_DS {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int dp[] = new int[N+1];
		for(int i=1;i<N+1;i++) {
			int a = (int)Math.sqrt(i);
			double b = Math.sqrt(i)%1;
			if(b>0) {
				int minDp = Integer.MAX_VALUE;
				for(int j=1;j<=a;j++) {
					minDp = Math.min(minDp,dp[i-j*j]);
				}
				dp[i] = minDp + 1;
			} else {
				dp[i] = 1;
			}
		}
		System.out.println(dp[N]);
	}
}
