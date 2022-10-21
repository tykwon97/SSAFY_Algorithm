package algo_study;

import java.io.*;
import java.util.*;

public class Main_S2_16953_AtoB {
	static long B;
	static long minDepth;
	static boolean isUpdated = false;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		long A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		minDepth = Integer.MAX_VALUE;
		
		bfs(A, 0);
		
		if(isUpdated) System.out.println(minDepth + 1);
		else System.out.println(-1);
	}
	
	static void bfs(long next, long depth) {
		ArrayDeque<long[]> queue = new ArrayDeque<>();
		queue.offer(new long[] {next, depth});
		
		while(!queue.isEmpty()) {
			long[] cur = queue.poll();
			next = cur[0];
			depth = cur[1];
			
			if(next == B) {
				// 가능함(처음 만난 연산이 최소연산)
				isUpdated = true;
				minDepth = minDepth < depth ? minDepth : depth;
				return;
			}
			
			if(next * 2 <= B)
				queue.offer(new long[] {next * 2, depth + 1});
			if(next * 10 + 1 <= B)
				queue.offer(new long[] {next * 10 + 1, depth + 1});
		}
		
	}
}
