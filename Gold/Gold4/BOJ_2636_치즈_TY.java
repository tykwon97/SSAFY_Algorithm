package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class N2636_Main {
	public static int[][] map;
	public static int height;
	public static int width;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());

		map = new int[height][width];

		int cheese = 0; // 시작 할 때의 치즈 개수
		
		for (int i = 0; i < height; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < width; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					cheese++;
			}
		}
		
		int cnt = 0; // 시간체크

		int flag = 1; // 남은 치즈 개수가 0일 때 종료하기 위한  flag
		while(flag != 0) {
			cnt++;
			flag = bfs(0,0); // (0,0)에서 계속 bfs
			if(flag != 0)
				cheese = flag;
		}
		System.out.println(cnt);
		System.out.println(cheese);

	}
	private static int bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		queue.offer(new int[]{startX,startY});

		boolean[][] isSelected = new boolean[height][width];
		int[] dx = {1,0,0,-1};
		int[] dy = {0,1,-1,0};

		while(!queue.isEmpty()) {
			int[] xy = queue.poll();
			int x = xy[0];
			int y = xy[1];

			for (int i = 0; i < 4; i++) {
				int nextX = x+dx[i];
				int nextY = y+dy[i];
				if(nextX<0 || nextY<0 || nextX>=height || nextY>=width)
					continue;
				if(isSelected[nextX][nextY]) // 이미 방문한 지역
					continue;

				if(map[nextX][nextY]==1)  //방문하지 않은 지역 중 치즈인 지역
					map[nextX][nextY] = 0;
				else 
					queue.offer(new int[] {nextX,nextY});

				isSelected[nextX][nextY] = true; // 방문 처리
			}
		}

		int count = 0; //남은 치즈 개수
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(map[i][j]==1)
					count++;
			}
		}

		return count;
	}
}
