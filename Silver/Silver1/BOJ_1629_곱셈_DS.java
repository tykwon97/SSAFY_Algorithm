package baekjoon.sliver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629_곱셈 {
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		long B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		long ans = qnsgkfwjdqhr(A%C, B);
		System.out.println(ans%C);
	}
	
	private static long qnsgkfwjdqhr(long x, long y) {
		if(y==1) return x;
		
		if(y%2==1) {
			long d = qnsgkfwjdqhr(x, y/2)%C;
			return  (d * d )%C * x;
		} else {
			long d = qnsgkfwjdqhr(x, y/2)%C;
			return (d * d)%C;
		}
	}
}
