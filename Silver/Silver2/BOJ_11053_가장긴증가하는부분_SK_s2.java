package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분_SK_s2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		int maxV = 1;
		
		for (int i = N-1; i >= 0; i--) {
			int cur = arr[i];
			dp[i] = 1;
			for (int j = i+1; j < N; j++) {
				if (arr[j] <= cur) continue;
				
				dp[i] = Math.max(dp[i], dp[j]+1);
				maxV = Math.max(maxV, dp[i]);		
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(maxV);
	}

}
