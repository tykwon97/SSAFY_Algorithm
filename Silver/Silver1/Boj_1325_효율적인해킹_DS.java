package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1325_효율적인해킹 {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<Integer>[] computer = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			computer[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			computer[y].add(x);
		}
		int max =0;
		int[] cnt = new int[N+1];
		for(int i=1;i<N+1;i++) {
			Deque<Integer> dq = new ArrayDeque<>();
			boolean[] isVisited = new boolean[N+1];
			dq.add(i);
			isVisited[i] = true;
			while(!dq.isEmpty()) {
				int x = dq.poll();
				for(int next : computer[x]) {
					if(!isVisited[next]) {
						cnt[i]++;
						dq.add(next);
						isVisited[next] = true;
					}
				}
			}
			max = max > cnt[i] ? max : cnt[i];
		}

		for(int i=1;i<N+1;i++) {
			if(cnt[i]==max) sb.append(i).append(" ");
		}
		System.out.println(sb);
	} 
}
