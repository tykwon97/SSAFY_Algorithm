package BOJ.Gold.Gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_º¸¼®µµµÏ {
	static class jewel implements Comparable<jewel> {
		int m;
		int v;
		public jewel(int m, int v) {
			super();
			this.m = m;
			this.v = v;
		}
		@Override
		public int compareTo(jewel o) {
			return m-o.m;
		} 
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<jewel> pq = new PriorityQueue<jewel>(new Comparator<jewel>() {

			@Override
			public int compare(jewel o1, jewel o2) {
				return o2.v-o1.v;
			}
		});
		ArrayList<jewel> jewels = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewels.add(new jewel(m,v));
		}
		Collections.sort(jewels);
		ArrayList<Integer> back = new ArrayList<>();
		for(int i=0;i<K;i++) {
			back.add(Integer.parseInt(in.readLine()));
		}
		Collections.sort(back);

		long sum = 0;
		
		int index = 0;
		for(int i=0;i<K;i++) {
			while(index<N) {
				if(back.get(i)>=jewels.get(index).m) {
					pq.add(jewels.get(index));
					index++;
				} else break;
			}
			if(!pq.isEmpty()) sum+=pq.poll().v;
		}
		System.out.println(sum);
	}
}
