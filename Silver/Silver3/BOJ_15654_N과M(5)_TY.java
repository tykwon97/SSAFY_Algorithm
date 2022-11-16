package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15654_Main {
	
	public static int N;
	public static int M;
	public static int[] list;
	public static boolean[] isSelected;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(in.readLine()," ");
		list = new int[N];
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);

		isSelected = new boolean[N];
		
		comb(0,"");
		
		System.out.println(sb);
	}

	private static void comb(int cnt, String result) {
		if(cnt == M) {
			sb.append(result).append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!isSelected[i]) {
				isSelected[i] = true;
				comb(cnt+1, result+(list[i])+" ");
				isSelected[i] = false;
			}
		}
	}
}
