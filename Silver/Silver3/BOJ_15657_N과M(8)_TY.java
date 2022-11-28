package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15657_Main {
	
	public static int N;
	public static int M;
	public static StringBuilder sb;
	public static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(in.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		perm(0,0,"");
		
		System.out.println(sb);
	}

	private static void perm(int cnt, int index, String result) {
		if(cnt == M) {
			sb.append(result).append("\n");
			return;
		}
		
		for (int i = index; i < N; i++) {
			perm(cnt+1, i, result+(arr[i])+" ");
		}
	}
}
