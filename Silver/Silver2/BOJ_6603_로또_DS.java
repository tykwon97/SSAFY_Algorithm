package BOJ.Sliver.Sliver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6603_·Î¶Ç {

	static int[] S;
	static int k=1;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(k!=0) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			S = new int[k];
			for(int i=0;i<k;i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] isSelected = new boolean[k];
			comb(0, 0, isSelected);
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt, int depth, boolean[] isSelected) {
		if(cnt==6) {
			for(int i=0;i<k;i++) {
				if(isSelected[i]) sb.append(S[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		if(depth==k) return;
		if(cnt + k - depth < 6) return;
		
		isSelected[depth] = true;
		comb(cnt+1, depth+1, isSelected);
		
		isSelected[depth] = false;
		comb(cnt, depth+1, isSelected);
	}
}
