package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11052_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		
		int[] list = new int[N+1];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			list[i] = Integer.parseInt(st.nextToken());			
		}
		
		int[] DP = new int[N+1];
		DP[0] = 0;
		DP[1] = list[1];
		
		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				DP[i] = Math.max(DP[i], DP[i-j] + list[j]);
			}
		}
		System.out.println(DP[N]);
	}
}
