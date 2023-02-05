package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_10610_30_JH {

	static ArrayList<Integer> arr, ans;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		boolean chk = false;  // true면 -1
		char[] arr = new char[num.length()];
		Integer[] list = new Integer[num.length()];
		arr = num.toCharArray();
		for(int i = 0; i < num.length(); i++) {
			list[i] = arr[i]-'0';
		}
		Arrays.sort(list, Collections.reverseOrder());
		int sum = 0;
		for(int i = 0; i < list.length; i++) {
			sum += list[i];
			sb.append(list[i]);
		}
		if(sum % 3 != 0) {
			chk = true;
		}
		if(list[0] == 0) {
			chk = true;
		}
		if(list[num.length()-1] != 0) {
			chk = true;
		}
		if(chk == true) {
			System.out.println("-1");
		} else {
			System.out.println(sb);
		}
	}
}
