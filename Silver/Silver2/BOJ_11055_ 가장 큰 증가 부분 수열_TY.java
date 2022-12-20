package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11055_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int [N];
		int maxSum = Integer.MIN_VALUE; // 합이 가장 큰 증가 부분 수열
		
		for (int i = 0; i < N; i++) {

			int prevMax = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[j] > prevMax) {
					prevMax = dp[j];
				}
			}
			
			if(prevMax == Integer.MIN_VALUE) // 이전 값들 보다 작은 경우
				prevMax = 0;
			
			dp[i] = prevMax+arr[i];
			
			if(dp[i] > maxSum) // 합이 가장 큰 경우
				maxSum = dp[i];
		}
		
		System.out.println(maxSum);
	}
}