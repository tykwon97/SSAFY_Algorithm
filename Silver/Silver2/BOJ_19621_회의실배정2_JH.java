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
		
		dp[0] = arr[0][2];
		for(int i = 1; i < N; i++) {
			int flag = 0;
			for(int j = i-1; j >= 0; j--) {
					if(arr[j][1] < arr[i][0] && dp[i] < dp[j] + arr[i][2]) {
						flag = 1;
						dp[i] = dp[j] + arr[i][2];
						continue;
					}
			}
			if(flag == 0) {
				dp[i] = arr[i][2];
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(dp[i]);
//		}
		
		Arrays.sort(dp);
		
		System.out.println(dp[N-1]);
	}
}
