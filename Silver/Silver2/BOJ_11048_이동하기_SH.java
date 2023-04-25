package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11048_이동하기_SH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = board[0][0];
		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + board[i][0];
		}
		for (int i = 1; i < M; i++) {
			dp[0][i] = dp[0][i - 1] + board[0][i];
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				int max = dp[i - 1][j];
				if (max < dp[i][j - 1]) {
					max = dp[i][j - 1];
				}
				if (max < dp[i - 1][j - 1]) {
					max = dp[i - 1][j - 1];
				}

				dp[i][j] = max + board[i][j];
			}
		}
		System.out.println(dp[N - 1][M - 1]);
	}
}
