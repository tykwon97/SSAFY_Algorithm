package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기_JH {
	static int[][] arr;
	static int white = 0, blue = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		fun(0, 0, N);
		System.out.println(white);
		System.out.println(blue);
	}
	
	private static void fun(int row, int col, int size) {
		if(check(row, col, size)) {
			if(arr[row][col] == 0)  // 흰종이면
				white += 1;
			else // 파랑이면
				blue += 1;
		} else {
			fun(row, col, size/2);
			fun(row+size/2, col, size/2);
			fun(row, col+size/2, size/2);
			fun(row+size/2, col+size/2, size/2);
		}
	}

	private static boolean check(int row, int col, int size) {
		int chk = 0;
		int val = arr[row][col];
		Loop1:
		for(int i = row; i < row+size; i++) {
			Loop2:
			for(int j = col; j < col+size; j++) {
				if(arr[i][j] != val) {
					chk = 1;
					break Loop1;
				}
			}
		}
		if(chk == 1) {
			return false;
		} else
			return true;
	}
	
	

}
