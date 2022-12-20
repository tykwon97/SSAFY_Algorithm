package prob.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_SK_s3 {
	
	private static int N, M;
	private static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // cnt of computer
		M = Integer.parseInt(br.readLine()); // count of computer pairs
		
		int[][] arr = new int[M][2];
		make(); // root 를 자기 자신으로 일치
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		for (int i = 2; i < N+1; i++) {
			if (find(1) == find(i)) cnt++;
		}
		
		System.out.println(cnt);
		
	}
	
	private static void make() {
		parent = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
	}
	
	private static int find(int a) {
		if (parent[a] == a) return a;
		
		return parent[a] = find(parent[a]); // path compression
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		parent[bRoot] = aRoot; // root 갱신
		return true;
	}

}
