package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052_물병_JH {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int min = -1;
		
		for(int i = 1; i <= K; i++) {  // K개까지의 물병만 만들 수 있음
			
			
			if(N == 0) {  // 물병 다 만들었으면 break
				min = 0;
				break;
			}
			
			
			int m = 0;
			while(true) {
				if(N <= Math.pow(2, m)) {
					break;
				}
				m++;
			}
			m -= 1;  // N보다 작은 최대 제곱수
			if(i == K) {  // 마지막 병인데 다 못만들면
				min = (int) Math.pow(2, m+1) - N;
				break;
			}
			
			N = N - (int) Math.pow(2, m);  // 최대 제곱수로 물병 하나 만들어서 빼줌
			
		}
		
		System.out.println(min);
	}
}
