package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1912_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		
		int[] list = new int[n];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MIN_VALUE);

		int maxValue = list[0];
		
		dp[0] = list[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(list[i], dp[i-1] + list[i]);
			if(maxValue < dp[i])
				maxValue = dp[i];
		}
			
//		System.out.println(Arrays.toString(dp));
		System.out.println(maxValue);
	}
}
