package Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724_연결요소의개수_DS {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for(int i=1;i<N+1;i++) {
			p[i] = i;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			union(x,y);
		}
		boolean[] ans = new boolean[N+1];
		for(int i=1;i<N+1;i++) {
			ans[FindSet(i)] = true;
		}
		int cnt=0;
		for(int i=1;i<N+1;i++) {
			if(ans[i]) cnt++;
		}	
		System.out.println(cnt);
	}
	
	static int FindSet(int x) {
		if(p[x]==x) return x;
		return FindSet(p[x]);
	}
	
	static void union(int x, int y) {
		if(FindSet(x)==FindSet(y)) return;
		else {
			p[FindSet(y)] = FindSet(x);
		}
	}

}
