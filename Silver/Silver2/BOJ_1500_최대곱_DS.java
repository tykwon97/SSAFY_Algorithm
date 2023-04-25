package BOJ.Sliver.Sliver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1500_ÃÖ´ë°ö {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long max = 1;
		
		int base = S / K;
		int add = S % K;
		for(int i=0;i<K;i++) {
			int x = 0;
			if(i<add) x = 1;
			max *= (base+x);
		}
		System.out.println(max);
	}
}
