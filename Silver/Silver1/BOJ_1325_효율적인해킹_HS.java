package algo_study;

import java.io.*;
import java.util.*;

public class Main_S1_1325_효율적인해킹 {
	static int[] counter;
	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		counter = new int[N+1];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		int max = 0;
		for(int i = 1; i < N+1; i++) {
			visited = new boolean[N+1];
			
			if(!visited[i]) {
				bfs(i);
			}
		}
//		for(int i = 1; i < N+1; i++) {
//			visited = new boolean[N+1];
//			
//			if(!visited[i]) {
//				visited[i] = true;
//				dfs(i);
//			}
//		}
//		
		for(int i = 1; i < N+1; i++) {
			max = max > counter[i] ? max : counter[i];
		}
		
		for(int i = 1; i < N+1; i++) {
			if(counter[i] == max) {
				sb.append(i).append(" ");
			}
		}
		
		System.out.println(sb);
	}
	
//	static void dfs(int index) {	
//		for(int i = 0, size = list[index].size(); i < size; i++) {		
//			if(!visited[list[index].get(i)]) { // 방문하지 않았다면
//				
//				visited[list[index].get(i)] = true;
//				counter[list[index].get(i)]++;
//				dfs(list[index].get(i));
//			}
//		}
//	}
	
	static void bfs(int index) {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		visited[index] = true;
		queue.offer(index);
		
		while(!queue.isEmpty()) {
			Integer cur = queue.poll();
			
			for(int next : list[cur]) {
				if(!visited[next]) {
					visited[next] = true;
					counter[next]++;
					queue.offer(next);
				}
			}
		}
	}
}
