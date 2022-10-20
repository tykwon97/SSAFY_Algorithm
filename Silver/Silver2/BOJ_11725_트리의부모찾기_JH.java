package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {
  
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());  // 노드 수
		
		int[] parent = new int[N+1];  // 인덱스 : 노드번호, 원소 : 부모 노드번호
		boolean[] visited = new boolean[N+1];  // 방문 노드 배열
		ArrayList<Integer>[] arr = new ArrayList[N+1];  // 2차원 AL
		for(int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		
		for(int i = 1; i < N; i++) {  // 연결된 노드들 저장  -------------------- N-1번만
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			arr[n1].add(n2);
			arr[n2].add(n1);
		}
		
		
		for(int i = 1; i <= N; i++) {  // 1번이 루트이므로 루트부터 차차 탐색
			if(!visited[i]) {  // 방문되지않았다면
				dfs(arr, visited, i, parent);
			}
		}
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
		
	}

	private static void dfs(ArrayList<Integer>[] arr, boolean[] visited, int i, int[] parent) {  // i번째 노드의 자식 노드들의 부모(i)체크
		if(!visited[i]) {  // 방문된게 아니라면
			visited[i] = true;
			for(int k : arr[i]) {  // 현재노드랑 연결된 노드들 모두
				if(!visited[k]) {
					parent[k] = i; // 자식노드들의 부모는 i
					dfs(arr, visited, k, parent);
				}
			}
		} else {
			return;
		}
		
	}
}
