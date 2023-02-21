package BOJ.Sliver.Sliver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_1343_폴리오미노 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String board = in.readLine();
		String Answer ="";
		int cnt = 0;
		for(int i=0;i<board.length();i++) {
			if(board.charAt(i)=='X') {
				cnt++;
				if(cnt==4) {
					Answer = Answer.concat("AAAA");
					cnt=0;
				}
			} else if(board.charAt(i)=='.') {
				if(cnt==2) {
					Answer= Answer.concat("BB");
					cnt=0;
				} else if(cnt==0) {
		
				} else {
					Answer = "-1";
					break;
				}
				Answer= Answer.concat(".");
			}
		}
		if(cnt==2) Answer = Answer.concat("BB");
		else if(cnt>0) Answer = "-1";
		System.out.println(Answer);
	}
}
