package baekjoon.bronze;

import java.util.Arrays;
import java.util.Scanner;

public class Boj_1085_직사각형에서탈출{
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int[] dist = {x, y, w-x, h-y};
		
		Arrays.sort(dist);
		System.out.println(dist[0]);
		sc.close();
	}	

}
