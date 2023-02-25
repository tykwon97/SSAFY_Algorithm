package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1500_Main {
	public static int S;
	public static int K;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int share = S/K;
		int remainder = S%K;

		long maxSumValue = 1;	
		
		for (int i = 0; i < K; i++) {
			if(remainder>0) {
				maxSumValue *= (share+1);
				remainder--;
			}else {
				maxSumValue *= share;
			}
		}
		
		System.out.println(maxSumValue);
	}
}
