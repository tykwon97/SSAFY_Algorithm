package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_평범한배낭 {

	static class product {
		int W;
		int V;
		public product(int w, int v) {
			super();
			W = w;
			V = v;
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		product[] pList = new product[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());			
			pList[i] = new product(w, v);
		}
		int[] dp = new int[K+1];
		for(int i=0;i<N;i++) {
			for(int j=K;j>=pList[i].W;j--) {
				dp[j] = Math.max(dp[j], dp[j-pList[i].W] + pList[i].V);
			}
			
		}
		
		System.out.println(dp[K]);
	}

	
}
