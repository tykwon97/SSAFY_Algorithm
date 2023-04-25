package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가부분수열_SH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] sum = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			num[i] = temp;
			sum[i] = temp;
		}
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(num[i] > num[j]) {
					sum[i] = Math.max(sum[j] + num[i], sum[i]);
				}
			}
		}
		Arrays.sort(sum);
		System.out.println(sum[N - 1]);
	}
}
