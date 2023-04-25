package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_연속합_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		int max = arr[0];
		for(int i = 1; i < N; i++) {
			if(dp[i] < dp[i-1] + arr[i]) {
				dp[i] = dp[i-1] + arr[i];
			}
			if(max < dp[i])  //  위의 if문 안에 넣어서 틀림^^
				max = dp[i];
		}
		
		System.out.println(max);
	}
}
