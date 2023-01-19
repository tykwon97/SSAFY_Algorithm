package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14620_꽃길_JH {

	static int dx[] = {0, -1, 1, 0, 0}; // 상하좌우
	static int dy[] = {0, 0, 0, -1, 1};
	static int n;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < n*n; i++) {
			for(int j = 0; j < n*n; j++) {
				for(int k = 0; k < n*n; k++) {
					int sum = chk(i, j, k);
					ans = (ans > sum)?sum:ans;
				}
			}
		}
		System.out.println(ans);
	}
	private static int chk(int i, int j, int k) {
		int ans = 0;
		int[] list = new int[3];
		list[0] = i;
		list[1] = j;
		list[2] = k;
		boolean[][] visited = new boolean[n][n];
		for(int z: list) {
			int x = z/n;
			int y = z%n;
			
			if(x==0 || x==(n-1) || y==0 || y==(n-1)) {
				return Integer.MAX_VALUE;
			}
			
			
			for(int a = 0; a < 5; a++) {
				int nx = x + dx[a];
				int ny = y + dy[a];
				if(!visited[nx][ny]) {
					visited[nx][ny] = true;
					ans += arr[nx][ny];
				} else {
					return Integer.MAX_VALUE;
				}
			}
		}
		return ans;
	}
}
