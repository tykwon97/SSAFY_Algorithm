package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기_JH {
	
	static int N, M;
	
	public static class Node implements Comparable<Node> {
		int e;
		int cost;
		public Node(int e, int cost) {
			this.e = e;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {  // 비용순대로 정렬될수있도록
			return cost-o.cost;
		}
		
	}
	static boolean[] visited;
	static int[] dist;
	static ArrayList<ArrayList<Node>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {  // 범위가 1부터여서 N과 같거나 작다로 해줭야함...........................................
			list.add(new ArrayList<>());
		}
		visited = new boolean[N+1];
		dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(s).add(new Node(d, cost));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int ans = dijkstra(start, end);
		System.out.println(ans);
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));  // 시작점 설정해놓음!!
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int cur_end = cur.e;
			
			if(!visited[cur_end]) {
				visited[cur_end] = true;
				for(Node node : list.get(cur_end)) {  // 현 출발점에서
					if(!visited[node.e] && dist[node.e] > dist[cur_end] + node.cost) {  // 방문하지 않았고, 갱신가능하면, 그리고 초반 cur_end는 start임
						dist[node.e] = dist[cur_end] + node.cost;
						pq.add(new Node(node.e, dist[node.e]));
					}
				}
			}
		}
		
		return dist[end];
	}
}
