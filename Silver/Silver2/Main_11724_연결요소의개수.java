package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	static int N, M, cnt;
	static int[][] arr;
	static int[] visited;
	
	public static void dfs(int s) {
		for(int j = 1; j < N+1; j++) {
			if(arr[s][j] == 1 && visited[j] == 0) { // 연결되어있고 방문되지않았다면
				visited[j] = 1;
				dfs(j);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		visited = new int[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s][e] = 1;
			arr[e][s] = 1;
		}
		int ans = 0;
		for(int i = 1; i < N+1; i++) {
			if(visited[i] == 0) { // 방문되지 않았다면
				visited[i] = 1;
				dfs(i);
				ans++;
			}
		}
		System.out.println(ans);
	}
}
