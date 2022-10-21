package boj_class03;

import java.io.*;
import java.util.*;

public class Main_G5_16928_뱀과사다리게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사다리
		int M = Integer.parseInt(st.nextToken()); // 뱀
		
		Map<Integer, Integer> ladders = new HashMap<>();
		Map<Integer, Integer> snakes = new HashMap<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			ladders.put(from, to);
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			snakes.put(from, to);
		}
		
		boolean[] visited = new boolean[101];
		int minCount = Integer.MAX_VALUE;
		boolean find = false;
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		visited[1] = true;
		queue.offer(new Integer[] {1, 1});
		
		while(!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			int pos = cur[0];
			int count = cur[1];
			
			for(int k = 1; k <= 6; k++) {
				int next = pos + k;
				
				if(next >= 100) {
					minCount = count; // 찾았다
					find = true;
					break;
				}
				
				if(visited[next]) continue;
				
				if(ladders.containsKey(next)) {
					int newNext = ladders.get(next);
					visited[next] = true;
					visited[newNext] = true; // 다음에 이 자리 오면 이미 방문해서 같은 결과 출력하니까
					queue.offer(new Integer[] {newNext, count + 1});
				}else if(snakes.containsKey(next)) {
					int newNext = snakes.get(next);
					visited[next] = true;
					visited[newNext] = true; // 다음에 이 자리 오면 이미 방문해서 같은 결과 출력하니까
					queue.offer(new Integer[] {newNext, count + 1});
				}else {
					visited[next] = true;
					queue.offer(new Integer[] {next, count + 1});
				}
				
			}
			
			if(find) break;
		}
		
		System.out.println(minCount);
	}
}
