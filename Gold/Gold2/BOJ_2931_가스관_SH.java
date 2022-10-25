package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2931_가스관_SH {
	static int R, C;
	static char[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		visited = new boolean[R][C];
		int mr = 0;
		int mc = 0;
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
				if (board[i][j] == 'M') {
					mr = i;
					mc = j;
				} else if (board[i][j] == 'Z') {

				}
			}
		}
		bfs(mr, mc);
		int answerR = 0;
		int answerC = 0;
		char answer = ' ';
		loop: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == '#') {
					answerR = i + 1;
					answerC = j + 1;
					break loop;
				}
			}
		}
		boolean left = false;
		boolean right = false;
		boolean up = false;
		boolean down = false;
		if (answerR - 2 >= 0) {
			if (board[answerR - 2][answerC - 1] == '+' || board[answerR - 2][answerC - 1] == '|'
					|| board[answerR - 2][answerC - 1] == '1' || board[answerR - 2][answerC - 1] == '4') {
				up = true;
			}
		}
		if (answerC - 2 >= 0) {
			if (board[answerR - 1][answerC - 2] == '+' || board[answerR - 1][answerC - 2] == '-'
					|| board[answerR - 1][answerC - 2] == '1' || board[answerR - 1][answerC - 2] == '2') {
				left = true;
			}
		}
		if (answerR < R) {
			if (board[answerR][answerC - 1] == '+' || board[answerR][answerC - 1] == '|'
					|| board[answerR][answerC - 1] == '2' || board[answerR][answerC - 1] == '3') {
				down = true;
			}
		}
		if (answerC < C) {
			if (board[answerR - 1][answerC] == '+' || board[answerR - 1][answerC] == '-'
					|| board[answerR - 1][answerC] == '3' || board[answerR - 1][answerC] == '4') {
				right = true;
			}
		}
		if (up && left && down && right) {
			answer = '+';
		} else if (left && right) {
			answer = '-';
		} else if (up && down) {
			answer = '|';
		} else if (down && right) {
			answer = '1';
		} else if (up && right) {
			answer = '2';
		} else if (up && left) {
			answer = '3';
		} else {
			answer = '4';
		}
		System.out.println(answerR + " " + answerC + " " + answer);
	}

	static boolean canConnect(int homeR, int homeC, int r, int c, char x) {
		int[] dr = { -1, 1, 0, 0 }; // 다음 r좌표 거리 계산을 위한 배열
		int[] dc = { 0, 0, -1, 1 }; // 다음 c좌표 거리 계산을 위한 배열
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { homeR, homeC }); // 집에서 출발
		visited[homeR][homeC] = true;
		for (int i = 0; i < 4; i++) { // 다음 좌표 계산
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) { // 지도에서 벗어나면
				continue; // 패스
			}
			if (board[nextR][nextC] != '.' && !visited[nextR][nextC]) {
				q.add(new int[] { nextR, nextC });
			}
		}
		return true;
	}

	static void bfs(int r, int c) {
		int[] dr = { -1, 1, 0, 0 }; // 다음 r좌표 거리 계산을 위한 배열
		int[] dc = { 0, 0, -1, 1 }; // 다음 c좌표 거리 계산을 위한 배열
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c }); // 시작 r, c 좌표를 큐에 넣어줌
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) { // 다음 좌표 계산
			int nextR = r + dr[i];
			int nextC = c + dc[i];
			if (nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) { // 지도에서 벗어나면
				continue; // 패스
			}
			if (board[nextR][nextC] != '.' && !visited[nextR][nextC]) {
				q.add(new int[] { nextR, nextC });
			}
		}
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int currentR = temp[0];
			int currentC = temp[1];
			if (board[currentR][currentC] == '-') {
				if (board[currentR][currentC - 1] == '.') {
					board[currentR][currentC - 1] = '#';
				} else {
					if (!visited[currentR][currentC - 1]) {
						q.add(new int[] { currentR, currentC - 1 });
						visited[currentR][currentC - 1] = true;
					}
				}
				if (board[currentR][currentC + 1] == '.') {
					board[currentR][currentC + 1] = '#';
				} else {
					if (!visited[currentR][currentC + 1]) {
						q.add(new int[] { currentR, currentC + 1 });
						visited[currentR][currentC + 1] = true;
					}
				}
			}
			if (board[currentR][currentC] == '+') {
				if (board[currentR][currentC - 1] == '.') {
					board[currentR][currentC - 1] = '#';
				} else {
					if (!visited[currentR][currentC - 1]) {
						q.add(new int[] { currentR, currentC - 1 });
						visited[currentR][currentC - 1] = true;
					}
				}
				if (board[currentR][currentC + 1] == '.') {
					board[currentR][currentC + 1] = '#';
				} else {
					if (!visited[currentR][currentC + 1]) {
						q.add(new int[] { currentR, currentC + 1 });
						visited[currentR][currentC + 1] = true;
					}
				}
				if (board[currentR - 1][currentC] == '.') {
					board[currentR - 1][currentC] = '#';
				} else {
					if (!visited[currentR - 1][currentC]) {
						q.add(new int[] { currentR - 1, currentC });
						visited[currentR - 1][currentC] = true;
					}
				}
				if (board[currentR + 1][currentC] == '.') {
					board[currentR + 1][currentC] = '#';
				} else {
					if (!visited[currentR + 1][currentC]) {
						q.add(new int[] { currentR + 1, currentC });
						visited[currentR + 1][currentC] = true;
					}
				}
			}
			if (board[currentR][currentC] == '|') {
				if (board[currentR - 1][currentC] == '.') {
					board[currentR - 1][currentC] = '#';
				} else {
					if (!visited[currentR - 1][currentC]) {
						q.add(new int[] { currentR - 1, currentC });
						visited[currentR - 1][currentC] = true;
					}
				}
				if (board[currentR + 1][currentC] == '.') {
					board[currentR + 1][currentC] = '#';
				} else {
					if (!visited[currentR + 1][currentC]) {
						q.add(new int[] { currentR + 1, currentC });
						visited[currentR + 1][currentC] = true;
					}
				}
			}
			if (board[currentR][currentC] == '1') {
				if (board[currentR][currentC + 1] == '.') {
					board[currentR][currentC + 1] = '#';
				} else {
					if (!visited[currentR][currentC + 1]) {
						q.add(new int[] { currentR, currentC + 1 });
						visited[currentR][currentC + 1] = true;
					}
				}
				if (board[currentR + 1][currentC] == '.') {
					board[currentR + 1][currentC] = '#';
				} else {
					if (!visited[currentR + 1][currentC]) {
						q.add(new int[] { currentR + 1, currentC });
						visited[currentR + 1][currentC] = true;
					}
				}
			}
			if (board[currentR][currentC] == '2') {
				if (board[currentR][currentC + 1] == '.') {
					board[currentR][currentC + 1] = '#';
				} else {
					if (!visited[currentR][currentC + 1]) {
						q.add(new int[] { currentR, currentC + 1 });
						visited[currentR][currentC + 1] = true;
					}
				}
				if (board[currentR - 1][currentC] == '.') {
					board[currentR - 1][currentC] = '#';
				} else {
					if (!visited[currentR - 1][currentC]) {
						q.add(new int[] { currentR - 1, currentC });
						visited[currentR - 1][currentC] = true;
					}
				}
			}
			if (board[currentR][currentC] == '3') {
				if (board[currentR][currentC - 1] == '.') {
					board[currentR][currentC - 1] = '#';
				} else {
					if (!visited[currentR][currentC - 1]) {
						q.add(new int[] { currentR, currentC - 1 });
						visited[currentR][currentC - 1] = true;
					}
				}
				if (board[currentR - 1][currentC] == '.') {
					board[currentR - 1][currentC] = '#';
				} else {
					if (!visited[currentR - 1][currentC]) {
						q.add(new int[] { currentR - 1, currentC });
						visited[currentR - 1][currentC] = true;
					}
				}
			}
			if (board[currentR][currentC] == '4') {
				if (board[currentR][currentC - 1] == '.') {
					board[currentR][currentC - 1] = '#';
				} else {
					if (!visited[currentR][currentC - 1]) {
						q.add(new int[] { currentR, currentC - 1 });
						visited[currentR][currentC - 1] = true;
					}
				}
				if (board[currentR + 1][currentC] == '.') {
					board[currentR + 1][currentC] = '#';
				} else {
					if (!visited[currentR + 1][currentC]) {
						q.add(new int[] { currentR + 1, currentC });
						visited[currentR + 1][currentC] = true;
					}
				}
			}
		}
	}
}
