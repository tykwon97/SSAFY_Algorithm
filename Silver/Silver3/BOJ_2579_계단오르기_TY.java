package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2579_Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		int[] stairs = new int[N+1];
		for (int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(in.readLine());
		}
		
		if(N == 1) {
			System.out.println(stairs[1]);
			return;
		}
		
		int[][] result = new int[N+1][2];
		result[1][0] = stairs[1];
		result[1][1] = 0;
		result[2][0] = stairs[1]+stairs[2];
		result[2][1] = stairs[1];

		for (int i = 3; i <= N; i++) {
			int a = stairs[i]+stairs[i-1]+result[i-2][1];
			int b = stairs[i]+result[i-1][1];
			int c = result[i-1][0];
			result[i][0] = Math.max(a, b);	
			result[i][1] = c;	
		}

		
		System.out.println(result[N][0]);
	}
}
