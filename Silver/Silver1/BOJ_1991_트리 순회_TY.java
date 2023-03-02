package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1991_Main {
	public static char[][] list;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		
		list = new char[N+1][2];

		for (int i = 1; i <= N; i++) {
			char[] charNumList = in.readLine().toCharArray();
			int index = charNumList[0]-'A'+1;
			if(charNumList[2] != '.') {
				list[index][0] = (charNumList[2]);
			}
			
			if(charNumList[4] != '.') {
				list[index][1] = (charNumList[4]);
			}
		}
		
		preorder(1);
		sb.append("\n");
		
		inorder(1);
		sb.append("\n");
		
		postorder(1); 
		sb.append("\n");
		System.out.println(sb);
	}
	
	private static void preorder(int index) {
		if(list[index][0] == ' ' && list[index][1] == ' ') {
			return;
		}
		sb.append((char)('A'+(index-1)));
		if(list[index][0] != 0) {
			preorder(list[index][0]-'A'+1);
		}
		if(list[index][1] != 0) {
			preorder(list[index][1]-'A'+1);
		}
		
	}

	private static void inorder(int index) {
		if(list[index][0] == ' ' && list[index][1] == ' ') {
			return;
		}
		if(list[index][0] != 0) {
			inorder(list[index][0]-'A'+1);
		}
		sb.append((char)('A'+(index-1)));
		if(list[index][1] != 0) {
			inorder(list[index][1]-'A'+1);
		}
	}
	
	private static void postorder(int index) {
		if(list[index][0] == ' ' && list[index][1] == ' ') {
			return;
		}
		if(list[index][0] != 0) {
			postorder(list[index][0]-'A'+1);
		}
		if(list[index][1] != 0) {
			postorder(list[index][1]-'A'+1);
		}
		sb.append((char)('A'+(index-1)));
	}
}
