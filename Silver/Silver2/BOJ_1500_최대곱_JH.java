package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1500_최대곱_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(K == 0) {
			System.out.println(S);
			return;
		}
		
		int div = S/K;
		int mod = S%K;
		int res = 1;
		for(int i = 0; i < K; i++) {
			
			if(mod <= 0) {
				res *= div;
			} else {
				res *= (div+1);
				mod--;
			}
		}
		
		System.out.println(res);
	}
}
