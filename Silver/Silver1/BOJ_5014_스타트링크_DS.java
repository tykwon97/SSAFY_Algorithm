package BOJ.Sliver.Sliver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_5014_스타트링크 {
	static class state {
		int level;
		int cnt;
		public state(int level, int cnt) {
			super();
			this.level = level;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		boolean[] isVisited = new boolean[F+1];
		Queue<state> q = new LinkedList<state>();
		q.add(new state(S, 0));
		isVisited[0] = true;
		int answer = -1;
		while(!q.isEmpty()) {
			state ns = q.poll();
			int level = ns.level;
			if(level==G) {
				answer = ns.cnt;
				break;
			}
			if(level + U <= F && !isVisited[level + U]) {
				q.add(new state(level+U, ns.cnt+1));
				isVisited[level+U] = true;
			}
			if(level - D >= 0 && !isVisited[level - D]) {
				q.add(new state(level-D, ns.cnt+1));
				isVisited[level-D] = true;
			}
		}
		if(answer==-1) System.out.println("use the stairs");
		else System.out.println(answer);
	}
}
