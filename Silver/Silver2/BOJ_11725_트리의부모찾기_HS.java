package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_11725_트리의부모찾기 {
	static boolean[] visited;
	static int N;
	static int[] parent;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		parent = new int[N];
		list = new ArrayList[N];
		for(int i = 0; i < N; i++) { // 초기화
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			// 그래프 인접한 좌표 넣어주기
			list[a].add(b);
			list[b].add(a);
		}
		
		// 트리노드 1번에서 출발하므로
		bfs(0);
		
		for(int i = 1; i < N; i++) {
			sb.append(parent[i] + 1).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int idx) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited[idx] = true;
		queue.offer(idx);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i = 0, size = list[cur].size(); i < size; i++) {
				int next = list[cur].get(i);
				
				if(visited[next]) continue;
				
				// 방문한 적 없다면 cur값이 부모노드이므로 저장, next가 다음 탐색할 노드
				parent[next] = cur;
				visited[next] = true;
				queue.offer(next);
			}
		}
	}
}
