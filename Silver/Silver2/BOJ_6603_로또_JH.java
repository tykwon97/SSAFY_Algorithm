package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_로또_JH {

	static int n;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if(n == 0)
				break;
			else {
				arr = new int[n];
				visited = new boolean[n];				
				for(int i = 0; i < n; i++) {
					arr[i] = Integer.parseInt(st.nextToken());
				}
				
				dfs(0, 0);
				System.out.println();
			}
		}
	}

	private static void dfs(int depth, int k) {
		if(depth == 6) {
			for(int i = 0; i < n; i++) {
				if(visited[i]) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		}
		for(int i = k; i < n; i++) {
			visited[i] = true;
			dfs(depth+1, i+1);
			visited[i] = false;
		}
	}
}
