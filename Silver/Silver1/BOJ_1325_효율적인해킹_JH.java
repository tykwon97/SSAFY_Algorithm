package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325_효율적인해킹_JH {
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] ans = new int[N+1];
		ArrayList<Integer>[] arr = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp = Integer.parseInt(st.nextToken());
			arr[temp1].add(temp);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[N+1];

		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			Arrays.fill(visited, 0);
			queue.add(i);
			visited[i] = 1;
			while(!queue.isEmpty()) {
				int temp = queue.poll();
					if(arr[temp] == null)
						continue;
					for(int j = 0; j < arr[temp].size(); j++) {
						if(visited[arr[temp].get(j)] == 0) {
							queue.add(arr[temp].get(j));
							visited[arr[temp].get(j)] = 1;
							ans[arr[temp].get(j)]++;
						} else
							continue;
					}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			if(ans[i] > max)
				max = ans[i];
		}
		for(int i = 1; i <= N; i++) {
			if(ans[i] == max)
				System.out.print(i + " ");
		}
	}
}
