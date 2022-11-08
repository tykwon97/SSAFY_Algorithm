package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N1629_Main {

	public static long A;
	public static long B;
	public static long C;

	public static HashMap<Long, Long> map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		// 계산 전에 미리 A값을 C로 나누어 작게 만든다.
		A %= C;

		long result = calc(B);

		System.out.println(result);
	}

	private static long calc(long index) {

		if(index == 1)
			return A;

		long temp = calc(index/2);

		if(index%2 == 0) { 
			temp =  temp*temp;
			temp %= C; 
		}else { 
			temp = temp * temp;
			temp %= C; 
			temp *=A;
			temp %= C; 
		}

		return temp;
	}
}
