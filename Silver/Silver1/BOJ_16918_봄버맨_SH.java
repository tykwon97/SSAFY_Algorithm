package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨_SH {
	static int R, C, S;
	static char[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		for (int s = 1; s < S + 1; s++) {
			if (s == 1) {
				changeBomb();
			} else if (s % 2 == 0) {
				fillBomb();
			} else if (s % 2 == 1) {
				explodeBomb();
				afterExplodeBomb();
			}
		}
		toResult();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	static void changeBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'A';
				}
			}
		}
	}

	static void fillBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '.') {
					board[i][j] = 'B';
				}
			}
		}
	}

	static void explodeBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'A') {
					int[] dr = { 0, 0, -1, 1 };
					int[] dc = { -1, 1, 0, 0 };
					for (int x = 0; x < 4; x++) {
						int nextR = i + dr[x];
						int nextC = j + dc[x];
						if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
							continue;
						}
						if (board[nextR][nextC] != 'A') {
							board[nextR][nextC] = '.';
						}
					}
				}
			}
		}
	}

	static void afterExplodeBomb() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'A') {
					board[i][j] = '.';
				}
				if (board[i][j] == 'B') {
					board[i][j] = 'A';
				}
			}
		}
	}

	static void toResult() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 'A' || board[i][j] == 'B') {
					board[i][j] = 'O';
				}
			}
		}
	}
}
