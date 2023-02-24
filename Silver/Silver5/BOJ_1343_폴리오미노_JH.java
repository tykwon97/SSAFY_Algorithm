package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1343_폴리오미노_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		char[] str = st.nextToken().toCharArray();
		int len = 0;
		for(int i = 0; i <= str.length; i++) {
			len++;
			if(i == str.length || str[i] == '.') {				
				len--;
				while(len != 0) {
					if(len >= 4) {
						for(int j = 0; j < 4; j++) {
							str[i-len] = 'A';
							len--;
						}
					} else if(len >= 2) {
						for(int j = 0; j < 2; j++) {
							str[i-len] = 'B';
							len--;
						}
					} else if(len == 1) {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		for(int i = 0; i < str.length; i++)
			System.out.print(str[i]);
	}
}
