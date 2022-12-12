package baekjoon.sliver.sliver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1052_물병 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String bN = Integer.toBinaryString(N);
		int cnt =0;
		int ans =0;
		int start = -1;
		for(int i=0;i<bN.length();i++) {
			if(cnt==K) {
				start = i; 
				break;
			}
			if(bN.charAt(i)=='1') cnt++;
		}
		if(start==-1) ans=0;
		else {
			boolean op = true;
			for(int i=bN.length()-1;i>=start;i--) {
				if(op&&bN.charAt(i)=='1') {
					ans += Math.pow(2, bN.length()-i-1);
					op = false;
				}
				if(!op&&bN.charAt(i)=='0') {
					ans += Math.pow(2, bN.length()-i-1);
				}
			}
		}
		
		System.out.println(ans);
	}

}
