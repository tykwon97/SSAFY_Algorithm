package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_19621_회의실배정2_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][3];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
			
		});
		
		for(int i = 0; i < N; i++) {
			dp[i] = arr[i][2];
		}
		for(int i = 1; i < N; i++) {
			for(int j = i-1; j >= 0; j--) {  // 이전 회의들과 시간비교
					if(arr[j][1] < arr[i][0] && dp[i] < dp[j] + arr[i][2]) {  // 두번째 조건 매우 중요! 최대 인원수 도출해야해서
						dp[i] = dp[j] + arr[i][2];
						continue;
					}
			}
			
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(dp[i]);
//		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
	}
}
