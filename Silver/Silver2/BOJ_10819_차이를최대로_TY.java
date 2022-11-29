package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N10819_Main {
	public static int N;
	public static int result;
	public static boolean[] isSelected;
	public static int[] list;
	public static int[] index;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine()," ");
		
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		result = Integer.MIN_VALUE;
		isSelected = new boolean[N];
		index = new int[N]; //순서 저장
		perm(0);

		System.out.println(result);
	}

	private static void perm(int count) {
		if(count == N) {
			int total = 0;
			for (int i = 0; i < N-1; i++) {
				total += Math.abs(list[index[i]] - list[index[i+1]]);
			}
			if(total>result)
				result = total;
			return;
		}
		
		
		for (int i = 0; i < N; i++) {
			if(N>3 && (count == 0 || count == N-1) && (i==0 || i==N-1))
				continue;
			if(!isSelected[i]) {
				isSelected[i] = true;
				index[count] = i;
				perm(count+1);
				isSelected[i] = false;
			}
		}
		
	}
}