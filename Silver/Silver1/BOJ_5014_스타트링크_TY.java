package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N5014_Main {

	public static int F;
	public static int S;
	public static int G;
	public static int U;
	public static int D;
	public static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// F, S, G, U, D
		st = new StringTokenizer(in.readLine(), " ");
		F = Integer.parseInt(st.nextToken());	
		S = Integer.parseInt(st.nextToken());	
		G = Integer.parseInt(st.nextToken());	
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		count = Integer.MAX_VALUE;
		
		bfs(S);
		
		if(count != Integer.MAX_VALUE)
			System.out.println(count);
		else
			System.out.println("use the stairs");
	}

	private static void bfs(int start) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		
		boolean[] isVisited = new boolean[F+1];
		
		queue.add(new int[] {start, 0});
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int loc = arr[0];
			int cnt = arr[1];
			
			if(isVisited[loc]) 
				continue;
			isVisited[loc] = true;
			
			if(loc == G) {
				if(count > cnt)
					count = cnt;
				return;
			}
			
			if(loc+U <= F) 
				queue.add(new int[] {loc+U, cnt+1});
			if(loc-D > 0) 
				queue.add(new int[] {loc-D, cnt+1});
		}
	}
}