package ty_algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_11724_연결요소의개수 {
	static int[] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수
		
		int[] counter = new int[N];
		
		parent = new int[N];
		make(N);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			
			// 여기서 연결하면 될듯
			union(from, to);
		}
		
		// 개수 세어야 함
		for(int i = 0; i < N; i++) {
			counter[find(i)]++;
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(counter[i] > 0) count++;
		}
		
		System.out.println(count);
	}
	
	static void make(int N) { // 자기 자신을 부모로
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if(parent[a] == a) return a;
		return find(parent[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a > b) parent[a] = b;
		else parent[b] = a;
	}
}
