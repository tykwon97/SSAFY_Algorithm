package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N17626_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[] lagrange = new int[N+1];

		for (int i = 1; i <= N; i++) {
			if(Math.sqrt(i)%1 == 0.0) { // 제곱수 인 경우
				lagrange[i] = 1;
			}else {
				lagrange[i] = Integer.MAX_VALUE; // 초기화
				
				int len = (int)Math.sqrt(i);

				for (int j = 1; j<=len; j++) {
					// 자기 자신에서 가능한 제곱수들 뺀 나머지 DP배열 값을 비교해서 최소값..
					lagrange[i] = Math.min(lagrange[i], lagrange[i-j*j] + 1);
					
					if(lagrange[i] == 2) // 가장 좋은 경우 일 때 바로 종료
						break;
				}
			}
		}

		System.out.println(lagrange[N]);
	}
}
