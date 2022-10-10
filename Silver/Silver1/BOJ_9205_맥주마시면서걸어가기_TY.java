package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class N9205_Main {

	public static List<int[]> list;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());

		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(in.readLine());
			
			st = new StringTokenizer(in.readLine(), " ");
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			
			list = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new int[] {x,y,0});	
			}
			
			st = new StringTokenizer(in.readLine(), " ");
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());	
			list.add(new int[] {endX,endY,1});	
			
			bfs(startX,startY);
		}	
		System.out.println(sb);	
	}

	private static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[] {startX,startY});
		HashMap<String, Integer> map = new HashMap<>();
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			
			for (int i = 0; i < list.size(); i++) {
				int[] node = list.get(i);
				int nodeX = node[0];
				int nodeY = node[1];
				int option = node[2];
				
				if(x==nodeX && y==nodeY)
					continue;
				
				int distance = Math.abs(x-nodeX)+Math.abs(y-nodeY);
				
				if(distance <= 1000){
					
					if(option == 1) {
						sb.append("happy").append("\n");
						return;
					}
					
					if(map.containsKey(nodeX+"."+nodeY))
						continue;
					
					map.put(nodeX+"."+nodeY, 0);
					queue.offer(new int[] {nodeX, nodeY});
				}
			}
		}
		sb.append("sad").append("\n");
	}
}
