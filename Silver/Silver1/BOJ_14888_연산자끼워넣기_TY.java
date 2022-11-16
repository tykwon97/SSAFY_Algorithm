package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14888_Main {

	public static int N;
	public static int[] list;
	public static int[] op;
	public static int max;
	public static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());

		list = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		op = new int[4];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		insrtOp(1,list[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}

	private static void insrtOp(int cnt, int result) {
		
		if(cnt == N) {
			if(result > max)
				max = result;
			if(result < min)
				min = result;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(op[i] >= 1) {
				op[i]--;
				
				int temp = result;
				if(i == 0) {
					temp += list[cnt];
				}else if(i == 1) {
					temp -= list[cnt];
				}else if(i == 2) {
					temp *= list[cnt];
				}else if(i == 3) {
					if(temp<0 && list[cnt]>0) {
						temp = Math.abs(temp);
						temp /= list[cnt];
						temp *= -1;
					}else {						
						temp /= list[cnt];
					}
				}
				
				insrtOp(cnt+1, temp);
				
				op[i]++;
			}
		}
		
	}
}
