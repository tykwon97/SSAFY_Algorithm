package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class N15663_Main2 {

	public static int N;
	public static int M;
	public static StringBuilder sb;
	public static int[] arr;
	public static boolean[] isSelected;
	public static HashSet<String> set;
	public static List<String> list;

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

		set = new HashSet<>();

		isSelected = new boolean[N];
		
		list = new ArrayList<>();
		
		perm(0,"");
		
		for(String result : list) {
			sb.append(result).append("\n");
		}

		System.out.println(sb);
	}

	private static void perm(int cnt,String result) {
		if(cnt == M) {
			if(!set.contains(result)) {
				set.add(result);
				list.add(result);				
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			perm(cnt+1, result + arr[i]+" ");
			isSelected[i] = false;
		}

	}
}
