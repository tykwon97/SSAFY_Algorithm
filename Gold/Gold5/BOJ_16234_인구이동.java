package baekjoon.gold.gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234_인구이동 {

	static class country {
		int pop;
		int group;
		int x;
		int y;
		public country(int pop, int group, int x, int y) {
			super();
			this.pop = pop;
			this.group = group;
			this.x = x;
			this.y = y;
		}

		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		country[][] c = new country[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				c[i][j] = new country(Integer.parseInt(st.nextToken()), 0, i, j);
			}
		}
		int gn = 1;
		int day = -1;
		while(gn<=N*N) {
			gn = 1;
			day++;
			ArrayList<Integer> spop = new ArrayList<>();
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					if(c[x][y].group==0) {
						c[x][y].group = gn;
						Queue<country> q = new LinkedList<>();
						q.add(c[x][y]);
						int cnt = 0;
						int sum = 0;
						while(!q.isEmpty()) {
							int[] dx = {1, -1, 0, 0};
							int[] dy = {0, 0, 1, -1};
							
							country cc = q.poll();
							sum += cc.pop;
							cnt++;
							for(int i=0;i<4;i++) {
								int nx = cc.x + dx[i];
								int ny = cc.y + dy[i];
									
								if(nx<0||ny<0||nx>=N||ny>=N) continue;
								
								if(c[nx][ny].group==0) {
									int dif = Math.abs(c[cc.x][cc.y].pop - c[nx][ny].pop);
									if(dif>=L&&dif<=R) {
										c[nx][ny].group = c[x][y].group;
										q.add(c[nx][ny]);
									}
								}
							}
						}
						spop.add(sum/cnt);
						gn++;
					}
				}
			}
					
			for(int x=0;x<N;x++) {
				for(int y=0;y<N;y++) {
					c[x][y].pop = spop.get(c[x][y].group-1);
					c[x][y].group=0;
				}
			}

		}
		System.out.println(day);
	}
}
