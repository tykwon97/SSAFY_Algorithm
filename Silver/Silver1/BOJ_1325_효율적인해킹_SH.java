package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인해킹_ {
	static int N, M;
	static List<Integer>[] graph;
	static boolean[] visited;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new List[N + 1];
		cnt = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		for (int i = 1; i < N + 1; i++) {
			visited = new boolean[N + 1];
			bfs(i);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < N + 1; i++) {
			max = Math.max(cnt[i], max);
		}
		for (int i = 1; i < N + 1; i++) {
			if (max == cnt[i])
				System.out.print(i + " ");
		}
	}

	static void bfs(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visited[idx] = true;
		while (!q.isEmpty()) {
			int element = q.poll();
			for (int e : graph[element]) {
				if (!visited[e]) {
					q.add(e);
					visited[e] = true;
					cnt[e]++;
				}
			}
		}
	}
}
