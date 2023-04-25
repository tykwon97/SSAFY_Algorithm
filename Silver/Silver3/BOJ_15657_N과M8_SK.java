package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657_N과M8 {
	
	static int N, M, arr[], choosed[];
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		choosed = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		perm(0, 0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	static void perm(int cnt, int start) {
		if (cnt == M) {
			for (int a: choosed) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = start; i < N; i++) {
			choosed[cnt] = arr[i];
			perm(cnt+1, i);
		}
		
	}

}
