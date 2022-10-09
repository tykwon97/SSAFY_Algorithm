package SSAFY_Algorithm.Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_1043_거짓말_DS {
	static int[][] plan;
	static int N, M;
	static int maxLie = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		boolean[] peopleTrue = new boolean[N+1];
		boolean[] peopleFalse = new boolean[N+1]; 
		st = new StringTokenizer(in.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		for(int i=0;i<T;i++) {
			peopleTrue[Integer.parseInt(st.nextToken())] = true;
		}
		plan = new int[M][];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			plan[i] = new int[n];
			for(int j=0;j<n;j++) {
				plan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		party(peopleTrue,peopleFalse, 0, 0);
		System.out.println(maxLie);
	}
	
	static void party(boolean[] peopleTrue,boolean[] peopleFalse, int time, int lie) {
		if(time==M) {
			maxLie = Math.max(maxLie, lie);
			return;
		}
		boolean liable = true;
		boolean turable = true;
		for(int i=0;i<plan[time].length;i++) {
			if(peopleTrue[plan[time][i]]) liable = false;
			if(peopleFalse[plan[time][i]]) turable = false;
		}
		if(liable) {
			boolean[] temp = new boolean[N+1];
			for(int i=1;i<N+1;i++) {
				temp[i] = peopleFalse[i];
			}
			for(int i=0;i<plan[time].length;i++) {
				peopleFalse[plan[time][i]] = true;
			}
			party(peopleTrue,peopleFalse, time+1, lie+1);
			for(int i=1;i<N+1;i++) {
				peopleFalse[i] = temp[i];
			}
		}
		if(turable) {
			boolean[] temp = new boolean[N+1];
			for(int i=1;i<N+1;i++) {
				temp[i] = peopleTrue[i];
			}
			for(int i=0;i<plan[time].length;i++) {
				peopleTrue[plan[time][i]] = true;
			}
			party(peopleTrue,peopleFalse, time+1, lie);
			for(int i=1;i<N+1;i++) {
				peopleTrue[i] = temp[i];
			}
		}
		if(!turable&&!liable) { 
			return;
		}
		
	}
}
