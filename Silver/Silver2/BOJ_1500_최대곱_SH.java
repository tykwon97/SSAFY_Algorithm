package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1500_최대곱_SH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		long S = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		long divNum = S / K;
		long restNum = S - (divNum * K);
		long answer = 1;
		for (long i = 0; i < K - restNum; i++) {
			answer *= divNum;
		}
		for (long i = 0; i < restNum; i++) {
			answer *= divNum + 1;
		}
		System.out.println(answer);
	}
}
