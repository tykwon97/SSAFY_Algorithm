package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N11724_Solution {
	
	public static int[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new int[N+1]; 
		for (int i = 1; i <= N; i++) { // 루트 노드를 자기 자신으로 초기화
			graph[i] = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < graph.length; i++) {
			set.add(findSet(graph[i]));
		}
		System.out.println(set.size());
	}

	private static void union(int a, int b) {
		if(findSet(a) != findSet(b)) {
			graph[findSet(graph[b])] = findSet(a);
		}
		
	}

	private static int findSet(int num) {
		if(num != graph[num]) {
			return graph[num] = findSet(graph[num]);
		}else {
			return num;
		}
	}
}
