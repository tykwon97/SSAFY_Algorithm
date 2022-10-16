package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int time = 0;
	static int N, M;
	static int[][] map;
	static int res; // 남아있는 치즈수
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static class Point{
		int x;
		int y;
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					res += 1; // 치즈 개수
				}
			}
		}
		while(true)
			if(bfs())
				break;
		
		System.out.println(time);
		System.out.println(res);
	}

	private static boolean bfs() {
		int[][] visited = new int[N][M];
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0,0)); //시작점 넣기
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(visited[nx][ny]==0) { // 방문되지않았다면
						visited[nx][ny] = 1; // 방문처리해주고
						if(map[nx][ny]==1) // 치즈면 -1해줌
							map[nx][ny] = -1;
						else
							queue.add(new Point(nx, ny));  //0이면 계속 탐색하게 큐에 삽입
					}
				}
			}
		}
		
		time++;
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j]==-1) {
					cnt += 1;
					map[i][j] = 0;
				}
			}
		}
		if(res != cnt) {
			res -= cnt;
		} else
			return true;
		return false;
			
		
	}
}
