package com.ssafy.algorithm;

public class BOJ_4673_셀프넘버_SH {
	public static void main(String[] args) {
		boolean[] isSelfNum = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			int temp = check(i);
			if (temp < 10001) {
				isSelfNum[temp] = true;
			}
		}
		for (int i = 1; i < 10001; i++) {
			if (!isSelfNum[i]) {
				System.out.println(i);
			}
		}
	}

	static int check(int N) {
		int sum = N;
		while (N > 0) {
			sum += N % 10;
			N /= 10;
		}
		return sum;
	}
}
