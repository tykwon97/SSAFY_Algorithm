package BOJ.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1107_¸®¸ðÄÁ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String N = in.readLine();
		int M = Integer.parseInt(in.readLine());
		boolean[] btn = new boolean[10];
		
		StringTokenizer st = null;
		if(M>0) st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			btn[num] = true;
		}
		Queue<String> q = new LinkedList<>();
		boolean isPossible = false;
		if(M==10) isPossible=true;
		String num=N;
		q.add(num);
		while(!isPossible) {
			num = q.poll();
			if(Integer.parseInt(num)<0) continue;
			for(int i=0;i<num.length();i++) {
				int n = num.charAt(i)-'0';
				if(btn[n]) break;
				if(i==num.length()-1) isPossible=true;
			}
			int m = Integer.parseInt(num);
			if(num.equals(N)) {
				q.add(Integer.toString(m-1));
				q.add(Integer.toString(m+1));
			} else if(m<Integer.parseInt(N)) {
				q.add(Integer.toString(m-1));
			} else {
				q.add(Integer.toString(m+1));
			}
		}
		int cnt = 0;
		if(M!=10) {
			cnt = num.length() + Math.abs(Integer.parseInt(num)-Integer.parseInt(N));
			cnt = Math.min(cnt, Math.abs(100-Integer.parseInt(N)));
		}
		else cnt = Math.abs(100-Integer.parseInt(N));
		System.out.println(cnt);
	}
}
