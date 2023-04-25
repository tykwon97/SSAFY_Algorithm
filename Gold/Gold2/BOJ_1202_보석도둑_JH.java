package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202_보석도둑_JH {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		int[] bag = new int[K];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			bag[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {  // 보석 정렬

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o2[1]-o1[1];
				} else {
					return o1[0]-o2[0];
				}
			}
			
		});
		
		Arrays.sort(bag);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		long ans = 0;
		int num = 0; // 몇번째 보석까지 탐색했는지
		for(int i = 0; i < K; i++) {
			for(int j = num; j < N; j++) {
				if(arr[j][0] <= bag[i]) {
					pq.add(arr[j][1]);
					num++;  // 보석 탐색 몇번째까지 했는지
				} else
                    break;
			}
			if(!pq.isEmpty())
				ans += pq.poll();
		}
		
		System.out.println(ans);
	}
}
