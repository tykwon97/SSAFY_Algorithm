package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class N1431_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());

		List<String> list = new LinkedList<>();
		for (int i = 0; i < N ; i++) {
			list.add(in.readLine());
		}

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int len = o1.length()-o2.length();
				if(len == 0) {
					int cnt1 = 0;
					for (int i = 0; i < o1.length(); i++) {
						char c = o1.charAt(i);
						if('0'<=c && c<='9') {
							cnt1 += (c-'0');
						}
					}

					int cnt2 = 0;
					for (int i = 0; i < o2.length(); i++) {
						char c = o2.charAt(i);
						if('0'<=c && c<='9') {
							cnt2 += (c-'0');
						}
					}

					if(cnt1 == cnt2) {
						for (int i = 0; i < o2.length(); i++) {
							if(o1.charAt(i) == o2.charAt(i)) {
								continue;
							}
							return o1.charAt(i) - o2.charAt(i);
						}
						return 0;
					}else {
						return cnt1-cnt2;
					}
				}else {
					return len;
				}
				
			}
		});	
		for(String str : list) {
			sb.append(str).append("\n");
		}
		System.out.println(sb);
	}
}
