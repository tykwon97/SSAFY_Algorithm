package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_JH {

	static int N;
	static int node;
	static ArrayList<Integer>[] arr;
	static Boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		node = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[N+1];  // 2차원 AL
		for(int i = 0; i <= N; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		visited = new Boolean[N+1];
		Arrays.fill(visited, false);
		
		for(int i = 0; i < node; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());
			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		while(!queue.isEmpty()) {
			int vir = queue.poll();  // 큐에서 꺼냄
			for(int i = 0; i < arr[vir].size(); i++) {
				int temp = arr[vir].get(i);  // vir과 연결된 모든 노드
				if(!visited[temp]) {  // 방문하지 않은 노드면
					queue.add(temp);
					visited[temp] = true;
				}
			}
		}
		
		int ans = -1;  // 더할때 1번 노드는 제외해야해서 미리빼줌
		for(int i = 1; i <= N; i++) {
			if(visited[i]) {
//				System.out.println(i);
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}
