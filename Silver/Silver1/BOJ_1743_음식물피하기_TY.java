package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1743_Main {
	public static boolean[][] isVisted;
	public static boolean[][] map;
	public static int maxValue;
	public static int N;
	public static int M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N+1][M+1];
		isVisted = new boolean[N+1][M+1];
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = true;
			queue.add(new int[] {r,c});
		}
		
		maxValue = Integer.MIN_VALUE;
		
		while(!queue.isEmpty()) {			
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			int count = bfs(x,y);
			if(maxValue < count)
				maxValue = count;
		}
		
		System.out.println(maxValue);
	}

	private static int bfs(int startX, int startY) {
		int[] dx = {1,0,0,-1};
		int[] dy = {0,1,-1,0};
		
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {startX, startY});
		
		int count = 0;
		
		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];
			
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || nx>N || ny<0 || ny>M)
					continue;
				if(map[nx][ny] && !isVisted[nx][ny]) {
					isVisted[nx][ny] = true;
					count++;
					queue.add(new int[] {nx, ny});
				}
			}
		}
		return count;
	}
}
