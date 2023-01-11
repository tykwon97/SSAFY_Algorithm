package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N10610_Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] numberString = in.readLine().toCharArray();
		int sum = 0;
		Arrays.sort(numberString);
		if(numberString[0] != '0') {
			System.out.println("-1");
			return;
		}
				
		for (int i = numberString.length-1; i >=0 ; i--) {
			sb.append(numberString[i]);
			sum += (numberString[i]-'0')%3;
		}
		if(sum%3==0) {
			System.out.println(sb);
		}else {
			System.out.println("-1");
		}
	}
}
