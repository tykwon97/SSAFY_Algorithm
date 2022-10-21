package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10819_차이를최대로 {
	
	static int ans;
	static int[] lst;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		lst = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		perm(N, 0, 0, arr, 0);
		System.out.println(ans);
	}

	public static void perm(int N, int cnt, int sum, int[] arr, int bf) {
		if (cnt == N) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (lst[i]==1)
				continue;
			lst[i] = 1;
			if (cnt == 0) { 
				perm(N, cnt + 1, sum, arr, i);
			} else {
				int tmp = Math.abs(arr[i] - arr[bf]);
				perm(N, cnt + 1, sum + tmp, arr, i);
			}
			lst[i] = 0;

		}
	}
}
