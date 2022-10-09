package SSAFY_Algorithm.Silver.Silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205_맥주마시면서걸어가기_DS {

	static class point {
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			point house = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			List<point> store = new ArrayList<>();
			for(int i=0;i<n;i++) {
				st = new StringTokenizer(in.readLine(), " ");
			    store.add(new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			st = new StringTokenizer(in.readLine(), " ");
			point festival = new point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			
			Queue<point> q = new LinkedList<>();
			q.add(house);
			boolean noAns = true;
			while(!q.isEmpty()) {
				point sang = q.poll();
				
				if(Math.abs(festival.x-sang.x)+Math.abs(festival.y-sang.y)<=1000) {
					sb.append("happy\n");
					noAns = false;
					break;
				}
				for(int i=0;i<store.size();i++) {
					point s = store.get(i);
					if(Math.abs(s.x-sang.x)+Math.abs(s.y-sang.y)<=1000) {
						q.add(s);
						store.remove(i);
					}
				}
			}
			if(noAns) sb.append("sad\n");
		}
		System.out.println(sb);
	}
}
