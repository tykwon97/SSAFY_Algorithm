package Silver.Silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로_DS {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		Deque<Integer> dq = new ArrayDeque<>();
		int n =0;
		for(int i=0;i<N/2;i++) {
			if(n%2==1) {
				dq.addFirst(A[i]);
				dq.addLast(A[N-1-i]);
			} else {
				dq.addFirst(A[N-1-i]);
				dq.addLast(A[i]);
			}
			n++;
		}
		if(N%2==1) {
			if(Math.abs(dq.getFirst()-A[N/2])<Math.abs(dq.getLast()-A[N/2])) {
				dq.addLast(A[N/2]);
			} else {
				dq.addFirst(A[N/2]);
			}
		}
		for(int i=0;i<N;i++) {
			A[i] = dq.pollFirst();
		}
		int sum = 0;
		for(int i=0;i<N-1;i++) {
			sum += Math.abs(A[i] - A[i+1]);
		}
		System.out.println(sum);	
	}
}
