package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가부분수열_JH {

	static int N;
	static int[] arr, len;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		len = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N; i++) {
			len[i] = arr[i];  // 초기 배열값 설정
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && len[i] < len[j]+arr[i]) {
					len[i] = len[j] + arr[i];
				}
			}
		}
		int ans = -1;
		for(int i = 0; i < N; i++) {
//			System.out.println(len[i]);
			if(len[i] > ans) {
				ans = len[i];
			}
		}
		System.out.println(ans);
	}
}
