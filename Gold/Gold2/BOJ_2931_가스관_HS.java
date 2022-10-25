package algo_study;

import java.io.*;
import java.util.*;

public class Main_G2_2931_가스관 {
	static char[][] map;

	// 사방탐색
	static int[] dr = { -1, 0, 1, 0 }; // 상하좌우 row
	static int[] dc = { 0, 1, 0, -1 }; // 상하좌우 col

	static int rows, cols;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());

		map = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int[] directions = new int[4];
		boolean breakFlag = false, okFlag = false;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int flag = 0;
				if (map[i][j] == '.') {
					if (i > 0) { // 상
						if (map[i - 1][j] == '1' || map[i - 1][j] == '4' || map[i - 1][j] == '|'
								|| map[i - 1][j] == '+') { // 위로 통로가 연결되어 있다면
							flag |= 1; // '상' 정보에 해당하는 플래그 값 1 추가
						}
					}
					if (j > 0) { // 좌
						if (map[i][j - 1] == '1' || map[i][j - 1] == '2' || map[i][j - 1] == '-'
								|| map[i][j - 1] == '+') { // 왼쪽으로 통로가 연결되어 있다면
							flag |= 2; // '좌' 정보에 해당하는 플래그 값 2 추가
						}
					}
					if (i < rows - 1) { // 하
						if (map[i + 1][j] == '2' || map[i + 1][j] == '3' || map[i + 1][j] == '|'
								|| map[i + 1][j] == '+') { // 아래로 통로가 연결되어 있다면
							flag |= 4; // '하' 정보에 해당하는 플래그 값 4 추가
						}
					}
					if (j < cols - 1) { // 우
						if (map[i][j + 1] == '3' || map[i][j + 1] == '4' || map[i][j + 1] == '-'
								|| map[i][j + 1] == '+') { // 오른쪽으로 통로가 연결되어 있다면
							flag |= 8; // '우' 정보에 해당하는 플래그 값 8 추가
						}
					}
				}

				if (flag != 0) {
					for (int k = 0; k < 4; k++) {
						if ((flag & 1 << k) != 0) { // &연산의 결과가 0이 아니라면 1,2,4,8 즉, 상하좌우에 대한 플래그 값이 있다는 것
							directions[k] = 1;
						}
					}

					if (directions[0] == 1 && directions[1] == 1 && directions[2] == 1 && directions[3] == 1) { // 상하좌우
																												// -> +
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("+");
						okFlag = true;
					} else if (directions[0] == 1 && directions[1] == 1) { // 좌상 -> 3
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("3");
						okFlag = true;
					} else if (directions[0] == 1 && directions[2] == 1) { // 상하 -> |
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("|");
						okFlag = true;
					} else if (directions[0] == 1 && directions[3] == 1) { // 우상 -> 2
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("2");
						okFlag = true;
					} else if (directions[1] == 1 && directions[2] == 1) { // 좌하 -> 4
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("4");
						okFlag = true;
					} else if (directions[1] == 1 && directions[3] == 1) { // 좌우 -> -
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("-");
						okFlag = true;
					} else if (directions[2] == 1 && directions[3] == 1) { // 우하 -> 1
						sb.append(i + 1).append(" ").append(j + 1).append(" ").append("1");
						okFlag = true;
					}

					for (int k = 0; k < 4; k++) {
						if ((flag & 1 << k) != 0) {
							directions[k] = 0; // 해당 방향에 대한 정보 초기화
						}
					}

					if (okFlag) {
						breakFlag = true;
						break;
					}
				}
			}
			if (breakFlag)
				break;
		}
		System.out.println(sb);
	}
}
