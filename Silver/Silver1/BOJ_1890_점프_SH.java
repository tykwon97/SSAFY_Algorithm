package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1890_점프_SH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		long[][] dp = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = 1;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dp[i][j] == 0) {
					continue;
				}
				if(i == N - 1 && j==N-1) {
					continue;
				}
				int move = board[i][j];
				int nextR = i + move;
				int nextC = j + move;
				if(nextR < N) {
					dp[nextR][j] += dp[i][j];
				}
				if(nextC < N) {
					dp[i][nextC] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N - 1][N - 1]);
	}
}
