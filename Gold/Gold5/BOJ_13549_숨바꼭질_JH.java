package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[200000];
		boolean[] visited = new boolean[200000];
		Deque<Integer> queue = new LinkedList<>();
		queue.addFirst(N);  // 출발점
		visited[N] = true;
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[N] = 0;  // 0이 아니라 출발점N ㅡㅡ
		while(!queue.isEmpty()) {
			int num = queue.poll();  // 지점
			if(num == M) {
				System.out.println(arr[M]);
				return;
			}
			if(num*2 < 200000 && arr[num] < arr[num*2]) {
				arr[num*2] = arr[num];
				queue.addFirst(num*2);
			}
			if(num+1 < 200000 && arr[num]+1 < arr[num+1]) {
				arr[num+1] = arr[num] + 1;
				queue.addLast(num+1);
			}
			if(num-1 >= 0 && arr[num]+1 < arr[num-1]) {
				arr[num-1] = arr[num] + 1;
				queue.addLast(num-1);
			}
		}
		
	}
}
