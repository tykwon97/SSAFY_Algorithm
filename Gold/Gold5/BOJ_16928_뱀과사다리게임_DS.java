package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16928_뱀과사다리게임 {

	static class dice {
		int loc;
		int cnt;
		public dice(int loc, int cnt) {
			super();
			this.loc = loc;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] map = new int[101];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x] = y;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x] = y;
		}
		Queue<dice> q = new LinkedList<dice>();
		q.add(new dice(1, 0));
		boolean isVisited[] = new boolean[101];
		while(!q.isEmpty()) {
			dice x = q.poll();
			int loc = x.loc;
			isVisited[loc] = true;
			int cnt = x.cnt;
			if(map[loc]!=0) {
				loc = map[loc];
			}
			isVisited[loc] = true;
			if(loc==100)  {
				System.out.println(x.cnt);
				break;
			}
			for(int i=6;i>=1;i--) {
				if(loc+i<=100&&!isVisited[loc+i])
				q.add(new dice(loc+i, cnt+1));
			}
		}
	}
}
