package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16935_AB {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while(A<B) {
			int n = B%10;
			if(n!=1&&B%2==1) break;
			if(n==1) {
				B = B/10;
				cnt++;
			} else {
				B = B/2;
				cnt++;
			}
		}
		if(A!=B) cnt = -2;
		System.out.println(cnt+1);
	}
}
