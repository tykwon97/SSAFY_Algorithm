package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class N15666_Main {

	public static int N;
	public static int M;
	public static int[] arr;
	public static HashSet<String> set;
	public static List<String> results;
	public static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine()," ");
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		set = new HashSet<>();
		results = new ArrayList<>();
		
		perm(0,"",-1);
		
		for(String result : results)
			sb.append(result).append("\n");
		System.out.println(sb);
	}

	private static void perm(int cnt, String result, int prev) {
		if(cnt == M) {
			if(!set.contains(result)) {
				set.add(result);
				results.add(result);				
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(prev > arr[i]) continue;
			perm(cnt+1, result+arr[i]+" ",arr[i]);
		}
	}
}
