package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N15565_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int result = N+1;
		
		int cnt = 0; // 1부터 다음 1까지의 사이즈
		int temp = 0; // 1을 k가 포함하는 경우의 사이즈
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());

			cnt++;
			
			if(x==1) {
				queue.add(cnt);
				
				temp += cnt;

				K--;
				
				if(K<=0) {
					temp -= queue.poll();
					
					if(result > temp)
						result = temp;
				}
				
				cnt = 0;				
			}
		}
		
		System.out.println((K<=0)?result+1:"-1");
	}
}



