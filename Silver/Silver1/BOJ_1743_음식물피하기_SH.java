package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1743_음식물피하기_SH {
	static int[][] board;
	static int R, C, K;
	static boolean[][] visited;
	static int max;
	static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		board = new int[R + 1][C + 1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;
		}
		visited = new boolean[R + 1][C + 1];
		max = Integer.MIN_VALUE;
		for (int i = 0; i < R + 1; i++) {
			for (int j = 0; j < C + 1; j++) {
				size = 0;
				if (board[i][j] == 1 && !visited[i][j]) {
					size = 1;
					visited[i][j] = true;
					dfs(i, j);
				}
				if (size > max) {
					max = size;
				}
			}
		}
		System.out.println(max);
	}

	static void dfs(int r, int c) {
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		for (int i = 0; i < 4; i++) {
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 1 || nextR >= R + 1 || nextC < 1 || nextC >= C + 1) {
				continue;
			}
			if (board[nextR][nextC] == 1 && !visited[nextR][nextC]) {
				visited[nextR][nextC] = true;
				size += 1;
				dfs(nextR, nextC);
			}
		}
	}
}
