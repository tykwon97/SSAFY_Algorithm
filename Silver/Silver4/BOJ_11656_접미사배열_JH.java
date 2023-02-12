package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11656_접미사배열_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		StringBuilder sb = new StringBuilder();
		ArrayList<String> arr = new ArrayList<>();  // 접미사 담을 배열
		for(int i = 0; i < str.length(); i++) {
			arr.add(str.substring(i));  // 앞에서부터 하나씩 자르기
		}
		Collections.sort(arr);
		for(int i = 0;i < arr.size(); i++)
			System.out.println(arr.get(i));
	}
}
