package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1780_종이의개수 {
	static int[][] arr;
	static int X, Y, Z; // -1,0,1의 개수
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
		
		count(0,0,N);  // 각각 개수 세기
		System.out.println(X);
		System.out.println(Y);
		System.out.println(Z);
	}
	private static boolean check(int r, int c, int n) {
		for(int i = r; i < r+n; i++) {
			for(int j = c; j < c+n; j++) {
				if(arr[i][j] != arr[r][c]) {
					return false;
				}
			}
		}
		
		return true;
	}
	private static void count(int r, int c, int n) {
		if(check(r, c, n)) {  // 같은 수로 이루어져있으면 카운트 하나 더함
//			System.out.println(arr[r][c]);
			if(arr[r][c] == -1)
				X++;
			if(arr[r][c] == 0)
				Y++;
			if(arr[r][c] == 1)
				Z++;
			return;
		}
		
		int size = n/3;
		
		for(int i = r; i < r+n; i+=size) {
			for(int j = c; j < c+n; j+=size) {
				count(i, j, size);  // 1/3해서 다시 카운트
			}
		}
	}
}
