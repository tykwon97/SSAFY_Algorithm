package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1431_시리얼번호_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<String> arrlist = new ArrayList<>(); 
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			arrlist.add(str);
		}
		Collections.sort(arrlist, new Comparator<String>() {
			int ret = 0;

			@Override
			public int compare(String o1, String o2) {
				if(o1.length() < o2.length()) {
					ret = -1;
				} else if(o1.length() == o2.length()) {
					char[] ch1 = o1.toCharArray();
					char[] ch2 = o2.toCharArray();
					int sum1 = 0;
					int sum2 = 0;
					for(int i = 0; i < ch1.length; i++) {
						if(Character.isDigit(ch1[i]) == true) {
							sum1 += ch1[i]-'0';
						}
					}
					for(int i = 0; i < ch2.length; i++) {
						if(Character.isDigit(ch2[i]) == true) {
							sum2 += ch2[i]-'0';
						}
					}
					if(sum1 < sum2) {
						ret = -1;
					} else if(sum1 == sum2) {
						ret = o1.compareTo(o2);
					} else {
						ret = 1;
					}
				} else {
					ret = 1;
				}
				return ret;
			}
			
		});
		for(int i = 0; i < N; i++) {
			System.out.println(arrlist.get(i));
		}
	}
}
