package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2531_회전초밥_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		boolean coupon = false;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean[] visited = new boolean[d+1];  // 방문
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			
			coupon = false;
			Arrays.fill(visited, false);
			int cnt = 0;
			for(int j = 0; j < k; j++) {
				if(!visited[arr[(i+j)%N]]) {
					cnt++;
				}
				visited[arr[(i+j)%N]] = true;
				if(arr[(i+j)%N] == c)
					coupon = true;
			}
			if(!coupon) {
				cnt += 1;
			}
			max = (max < cnt)? cnt : max;

		}
		System.out.println(max);
	}
}
