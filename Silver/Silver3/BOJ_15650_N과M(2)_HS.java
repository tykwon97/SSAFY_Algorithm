package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {
	static StringBuilder sb = new StringBuilder();
	static int[] selected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		selected = new int[M];
		comb(N, M, 0, 1);
		
		System.out.println(sb);
	}
	
	static void comb(int N, int M, int count, int start) {
		if(count == M) {
			for(int i = 0; i < M; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			selected[count] = i;
			comb(N, M, count + 1, i + 1);
		}
	}
}
