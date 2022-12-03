package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형_SH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [][] board = new int[N][N];
		int [][] dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			dp[N - 1][i] = board[N - 1][i];
		}
		int cnt = N - 1;
		for(int i = N - 2; i >= 0; i--) {
			for(int j = 0; j < cnt; j++) {
				dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + board[i][j];
			}
			cnt--;
		}
		System.out.println(dp[0][0]);
	}
}
