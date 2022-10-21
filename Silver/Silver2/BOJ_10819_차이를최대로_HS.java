package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_10819_차이를최대로 {
	static int[] selected;
	static int[] nums;
	static int N, max = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		selected = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		perm(0, 0);
		
		System.out.println(max);
	}
	
	static void perm(int count, int flag) {
		if(count == N) {
			int sum = 0;
			for(int i = 0; i < N-1; i++) {
				sum += Math.abs(selected[i] - selected[i+1]);
			}
			
			max = max > sum ? max : sum;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((flag & 1 << i) != 0) continue;
			
			selected[count] = nums[i];
			perm(count + 1, flag | 1 << i);
		}
	}
}
