package gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16234_Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[][] people = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < N; j++) {
				people[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		
		int[] dx = {+1,-1,+0,+0};
		int[] dy = {+0,+0,+1,-1};
		boolean flag = true;
		while(flag) {
			flag = false;
			boolean[][] isVisited = new boolean[N][N]; // 방문한 곳 저장
			
			Queue<int[]> bfs; // bfs시 사용
			Queue<int[]> list; // 국경선을 연 국가들 저장
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					if(isVisited[i][j])
						continue;
					
					bfs = new ArrayDeque<int[]>();
					list = new ArrayDeque<int[]>();
					
					int total = 0;
					
					bfs.add(new int[] {i,j});
					list.add(new int[] {i,j});

					isVisited[i][j] = true;
					
					while(!bfs.isEmpty()) {
						int[] arr = bfs.poll();
						int x = arr[0];
						int y = arr[1];
						
						total += people[x][y];
						
						for (int k = 0; k < 4; k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							
							if(nx<0 || ny<0 || nx>=N || ny>=N)
								continue;
							
							if(isVisited[nx][ny])
								continue;
							
							int diff = Math.abs(people[x][y] - people[nx][ny]);
							
							if(diff>=L && diff<=R) {
								bfs.add(new int[] {nx,ny});
								list.add(new int[] {nx,ny});

								isVisited[nx][ny] = true;

								flag = true;
							}
						}
					}
					
					int size = list.size();
					total /= size;
					while(!list.isEmpty()) {
						int[] arr = list.poll();
						int x = arr[0];
						int y = arr[1];
						people[x][y] = total;
					}
				}
			}

			if(flag)
				day++;
		}
		System.out.println(day);
	}
}
