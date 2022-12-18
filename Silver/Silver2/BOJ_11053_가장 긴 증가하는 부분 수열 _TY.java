package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11053_Main {

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
		int count = Integer.MIN_VALUE; // 가장 긴 증가하는 부분 수열 개수
		
		for (int i = 0; i < N; i++) {

			int prevMax = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[j] > prevMax) {
					prevMax = dp[j];
				}
			}
			
			if(prevMax == Integer.MIN_VALUE) // 이전 값들 보다 작은 경우
				prevMax = 0;
			
			dp[i] = prevMax+1;
			
			if(dp[i] > count) // 가장 긴 증가하는 부분 수열인 경우
				count = dp[i];
		}
		
		System.out.println(count);
	}
}