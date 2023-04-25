package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가부분수열_SK {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int A = Integer.parseInt(br.readLine()); // 수열의 크기 A
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[A+1];
		for (int i = 1; i < A+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken()); // 수열 A를 이루고 있는 Ai 1 부터 A까지
		}
		
		int[] dp = new int[A+1]; // dp로 접근
		
		int ans = 0;
		for (int i = 1; i < A+1; i++) { // dp[2] ~ dp[A] 까지 탐색
			for (int j = i-1; j >= 0; j--) { // 매번 dp[i] 보다 작은 dp[j] 즉, i-1 ~ 1 까지 수 중 arr[i] 보다 작은 dp[j]의 최댓값 + arr[i] = dp[i] 가 된다.
				if (arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j] + arr[i], dp[i]);
					ans = Math.max(ans, dp[i]);
				}
			}
		}
		
		// System.out.println(Arrays.toString(dp)); // dp 구한 컨셉은 해당 값을 확인하면 쉽다. -> 현재 dp보다 작은 값의 최댓값을 구한다.
		System.out.println(ans);
		
	}

}
