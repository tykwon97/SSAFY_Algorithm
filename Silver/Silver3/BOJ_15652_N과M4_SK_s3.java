package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_15652_N과M4_SK_s3 {
	
	static int N, M;
	static int[] choosed;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		choosed = new int[M];
		dupComb(0, 1);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void dupComb(int cnt, int startIdx) {
		if (cnt == M) {
			for (int a: choosed)
				sb.append(a).append(" ");
			sb.append("\n");
			
			return;
		}
		
		for (int i = startIdx; i <= N; i++) {
			choosed[cnt] = i;
			dupComb(cnt+1, i);
		}
				
			
	}

}
