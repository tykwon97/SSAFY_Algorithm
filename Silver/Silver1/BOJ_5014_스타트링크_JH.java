package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] arr = new int[F+1];
		boolean[] visited = new boolean[F+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(S); // 시작점
		arr[S] = 1;
		visited[S] = true; // 방문
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			int next_u = cur + U;
			int next_d = cur - D;
			if(next_u <= F && !visited[next_u]) {  // 올라가는 버튼누름
				arr[next_u] = arr[cur]+1;  // 도달방법수 늘림
				queue.add(next_u);
				visited[next_u] = true;
			}
			if(next_d > 0 && !visited[next_d]) {  // 내려가는 버튼
				arr[next_d] = arr[cur]+1;  // 도달방법수 늘림
				queue.add(next_d);
				visited[next_d] = true;
			}
		}
		int ans = arr[G]-1;
		if(ans == -1) {
			System.out.println("use the stairs");
		} else
			System.out.println(arr[G]-1);
	}
}
