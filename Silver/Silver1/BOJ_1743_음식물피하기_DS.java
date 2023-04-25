package BOJ.Sliver.Sliver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ_1743_음식물피하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				map[i][j] = 0;
			}
		}
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y] = 1;
		}
		int max = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) {
					int cnt = 0;
					Queue<Integer> q = new LinkedList<Integer>();
					q.add(i*M+j);
					map[i][j] = 0;
					cnt++;
					while(!q.isEmpty()) {
						int[] dx = {1, -1, 0, 0};
						int[] dy = {0, 0, 1, -1};
						int n = q.poll();
						int nx = n/M;
						int ny = n%M;
						for(int k=0;k<4;k++) {
							if(nx+dx[k]<0||ny+dy[k]<0||nx+dx[k]>=N||ny+dy[k]>=M||map[nx+dx[k]][ny+dy[k]]==0) continue;
							q.add((nx+dx[k])*M + (ny+dy[k]));
							map[nx+dx[k]][ny+dy[k]]=0;
							cnt++;
						}
					}
					max = Math.max(max, cnt);
				}
			}
		}
		System.out.println(max);
	
	}
}
