package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.ForkJoinPool;

public class N1932_Main {
	public static int N;
	public static int max;
	public static int[] list;
	public static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		int[] a = new int[1];
		a[0] = Integer.parseInt(in.readLine());
		
		int[] b;
		for (int i = 2; i <= N; i++) {
			b = new int[i];
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < i; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < i; j++) {
				int left = -1;
				if(j>0) 
					left = a[j-1]+b[j];	
				
				int right = -1;
				if(j<i-1) 
					right = a[j]+b[j];					
				
				b[j] = Math.max(left, right);
			}
			
//			System.out.println(Arrays.toString(b));
			
			a = new int[i];
			for (int j = 0; j < i; j++) {
				a[j] = b[j];
			}
		}
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(a[i] > max)
				max = a[i];
		}
		
		System.out.println(max);
	}
}
