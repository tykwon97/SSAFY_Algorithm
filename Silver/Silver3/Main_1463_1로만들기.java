package algo;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463_1로만들기 {

	static int N;
	static int[] arr;
	
	public static int go(int n) {
		arr[1] = 0;
		for(int i = 2; i <= n; i++) {
			arr[i] = arr[i-1] + 1;
			if(i%2==0 && arr[i]>arr[i/2]+1) {
				arr[i] = arr[i/2]+1;
			}
			if(i%3==0 && arr[i]>arr[i/3]+1) {
				arr[i] = arr[i/3]+1;
			}
		}
		return  arr[n];
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
//		Arrays.fill(arr, -1);
		int ans = go(N); //상향식
		System.out.println(ans);
	}
}
