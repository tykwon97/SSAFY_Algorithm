package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용구하기 {
	static class node implements Comparable<node> {
		int d;
		int cost;
		public node(int d, int cost) {
			super();
			this.d = d;
			this.cost = cost;
		}
		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return cost-o.cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int M = Integer.parseInt(in.readLine());
		
		ArrayList<node>[] city = new ArrayList[N+1];
		for(int i=0;i<N+1;i++) {
			city[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			city[s].add(new node(d, cost));
		}
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int START = Integer.parseInt(st.nextToken());
		int END = Integer.parseInt(st.nextToken());
		
		int[] minPrice = new int[N+1];
		boolean[] isVisited = new boolean[N+1];
		Arrays.fill(minPrice, Integer.MAX_VALUE);
		minPrice[START] = 0;
		PriorityQueue<node> pq = new PriorityQueue<>();
		pq.add(new node(START, 0));
		while(!pq.isEmpty()) {
			node now = pq.poll();
			if(now.d == END) break;
			if(isVisited[now.d]) continue;
			for(int i=0;i<city[now.d].size();i++) {
				node next = city[now.d].get(i);
				if(minPrice[next.d] > now.cost + next.cost) {
					minPrice[next.d] = now.cost + next.cost;
					pq.add(new node(next.d, minPrice[next.d]));
				}
			}
		}
		System.out.println(minPrice[END]);

	}

}
