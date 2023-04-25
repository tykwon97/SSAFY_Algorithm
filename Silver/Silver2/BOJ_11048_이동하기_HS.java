package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_11048_이동하기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i > 0 && j > 0) map[i][j] += maxVal(map[i-1][j-1], map[i-1][j], map[i][j-1]);
				if(i == 0 && j > 0) map[i][j] += map[i][j-1];
				if(j == 0 && i > 0) map[i][j] += map[i-1][j];
			}
		}
		
		System.out.println(map[N-1][M-1]);
	}
	
	static int maxVal(int a, int b, int c) {
		if(a >= b && a >= c) return a;
		if(b >= c && b >= a) return b;
		return c;
	}
}
