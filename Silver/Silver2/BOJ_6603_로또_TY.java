package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N6603_Main {
	public static StringBuilder sb;
	public static int size;
	public static int[] list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		boolean flag = true;
		while(flag) {
			st = new StringTokenizer(in.readLine()," ");
			size = Integer.parseInt(st.nextToken());
			if(size == 0) {
				flag = false;
				break;
			}
			
			list = new int[size];
			for (int i = 0; i < size; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(list);
			
			comb(0,0,"");
			
			
			sb.append("\n");
		}		

		System.out.println(sb);
	}	

	private static void comb(int index, int count, String result) {
		if(count==6) {
			result = result.trim(); // result 앞에 " "추가 된 것 제거
			sb.append(result).append("\n");
			return;
		}
		
		// 남은 숫자를 모두 사용해도 6개가 안되는 경우
		if(size-index < 6-count)
			return;
		
		for (int i = index; i < size; i++) {
			comb(i+1, count+1, (result +" "+ list[i]));
		}
	}
}
