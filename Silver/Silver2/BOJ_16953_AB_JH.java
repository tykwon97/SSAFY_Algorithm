package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_AB_JH {
	static int n, m;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		fun(n, 0);
		if(ans == Integer.MAX_VALUE)
			System.out.println("-1");
		else
			System.out.println(ans+1);
	}

	private static void fun(int n, int i) {
		if(n == m) {
			ans = Math.min(i, ans);
			return;
		} else if(n > m) {
			return;
		}
		
		fun(n*10+1, i+1);
		fun(n*2, i+1);
	}

}
