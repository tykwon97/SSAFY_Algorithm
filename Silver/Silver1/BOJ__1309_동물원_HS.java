package algo_study;

import java.io.*;

public class Main_S1_1309_동물원 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 인덱스 0 : 현재 index에서 가능한 경우의 수
		
		// ex. 둘 다 비었을 때 -> 위(a, b)에 어느 값이 오던 상관 없음 -> dp[i-1][1];
		// 각 경우가 대칭이므로 a = b임!! 
		// 왼쪽만 채움 -> 위(a, b)에 왼쪽은 비어야하고 오른쪽은 상관 없음 -> b(=dp[i-1][0])
		// 오른쪽만 채움 -> 위(a, b)에 오른쪽은 비어야함 -> a(=dp[i-1][0])
		// 따라서 배열을 굳이 왼쪽, 오른쪽, dp 3열짜리로 만들 필요 없이 왼쪽=오른쪽, dp 2열짜리로 만듦 
		
		// 인덱스 1 : 가능한 dp 누적 값
		int[][] dp = new int[N][2];
		dp[0][0] = 2;
		dp[0][1] = 3;
		
		for(int i = 1; i < N; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-1][1];
			dp[i][1] = (dp[i-1][0] * 2 + dp[i-1][1]) % 9901;
		}
		
		System.out.println(dp[N-1][1]);
	}
}