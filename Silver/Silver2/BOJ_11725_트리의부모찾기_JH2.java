package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기_JH2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] parent = new int[N+1];
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			list[p1].add(p2);
			list[p2].add(p1);
		}
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for(int i = 0; i < list[1].size(); i++) {
			queue.add(list[1].get(i));
			visited[list[1].get(i)] = true;
			parent[list[1].get(i)] = 1;
		}
		while(!queue.isEmpty()) {
			int child = queue.poll();
//			if(!visited[child]) {
			for(int i = 0; i < list[child].size(); i++) {
				if(!visited[list[child].get(i)]) {
					queue.add(list[child].get(i));
					visited[list[child].get(i)] = true;
					parent[list[child].get(i)] = child;
				}
			}
//			}
		}
		for(int i = 2; i <= N; i++)
			System.out.println(parent[i]);
	}
}
