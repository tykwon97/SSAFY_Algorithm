package BOJ.Sliver.Sliver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	
	static int N;
	static int[] p;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		p  = new int[N+1];
		int M = Integer.parseInt(in.readLine());
		for(int i=0;i<N+1;i++) {
			p[i] = i;
		}
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Join(x, y);
		}
		int cnt=0;
		for(int i=2;i<N+1;i++) {
			if((FindSet(1)==FindSet(i))) cnt++;
		}
		System.out.println(cnt);
		
	}
	
	static int FindSet(int x) {
		if(p[x]==x) return x;
		else return p[x] = FindSet(p[x]);
	}
	static void Join(int x, int y) {
		if(FindSet(x)!=FindSet(y)) p[FindSet(x)] = p[FindSet(y)];
	}

}
