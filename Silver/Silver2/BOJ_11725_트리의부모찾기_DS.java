package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11725_트리의부모찾기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<N+1;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<N-1;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		int[] p = new int[N+1];
		boolean[] isVisited = new boolean[N+1];
		while(!q.isEmpty()) {
			int x = q.poll();
			int size = graph.get(x).size();
			isVisited[x] = true;
			for(int i=0;i<size;i++) {
				int y = graph.get(x).get(i);
				
				if(isVisited[y]) continue;
	
				p[y] = x;
				q.add(y);
			}
		}
		for(int i=2;i<N+1;i++) {
			sb.append(p[i]).append("\n");
		}
		System.out.println(sb);
	}
}
