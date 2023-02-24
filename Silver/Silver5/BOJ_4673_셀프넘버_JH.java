package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4673_셀프넘버_JH {

	static boolean arr[];
	public static void main(String[] args) throws IOException {
		arr = new boolean[10001];
		for(int i = 1; i < 10001; i++) {
			if(check(i)<10001) {
				arr[check(i)] = true;
			}
		}
		
		for(int i = 1; i < 10001; i++) {
			if(!arr[i])
				System.out.println(i);
		}
	}
	
	public static int check(int num) {
		int sum = num;
		while(num != 0) {
			sum += num%10;
			num/=10;
		}
		return sum;
	}
}
