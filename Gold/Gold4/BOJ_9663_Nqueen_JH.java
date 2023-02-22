package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9663_Nqueen_JH {

	static int[] arr;
	static int n, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		
		nQueen(0);
		System.out.println(ans);
	}

	public static void nQueen(int depth) {
		if(depth == n) {
			ans++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr[depth] = i;
			
			if(isPossible(depth))
				nQueen(depth+1);
		}
	}

	private static boolean isPossible(int depth) {
		for(int i = 0; i < depth; i++) {
			if(arr[depth] == arr[i])
				return false;
			else if((depth-i) == Math.abs(arr[depth]-arr[i]))
				return false;
		}
		return true;
	}
	
}
