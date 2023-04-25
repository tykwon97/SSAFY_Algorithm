package BOJ.Sliver.Sliver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {

	static class time implements Comparable<time> {
		int start;
		int end;
		
		public time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(time o) {
			if(this.end==o.end) {
				return this.start-o.start;
			}
			return this.end - o.end;
		}	
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<time> t = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			t.add(new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}	
		Collections.sort(t);
		int pre = 0;
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(pre<=t.get(i).start) {
				cnt++;
				pre = t.get(i).end;
			}
		}
		System.out.println(cnt);
	
		
	}
}
