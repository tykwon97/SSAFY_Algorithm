package boj.s3;

import java.io.*;

public class Main_S3_2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (N == 1)
			System.out.println(arr[1]);
		else if (N == 2)
			System.out.println(arr[1] + arr[2]);
		else {

			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];
			for (int i = 3; i <= N; i++) {
				dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
			}

			System.out.println(dp[N]);
		}
	}
}
