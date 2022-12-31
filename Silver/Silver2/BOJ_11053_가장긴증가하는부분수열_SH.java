package com.ssafy.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열_SH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		int[] len = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			num[i] = temp;
			len[i] = 1;
		}
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(num[i] > num[j]) {
					len[i] = Math.max(len[j] + 1, len[i]);
				}
			}
		}
		Arrays.sort(len);
		System.out.println(len[N - 1]);
	}
}
