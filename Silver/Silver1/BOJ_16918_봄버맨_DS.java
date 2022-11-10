package baekjoon.sliver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {

	static int R, C, N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb = new StringBuilder();
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for(int i=0;i<R;i++) {
			String str = in.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = str.charAt(j);
			}
		}
		if(N==1) { 
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		} else if(N%2==0) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					sb.append('O');
				}
				sb.append("\n");
			}
		} else {
			char[][] nextmap = bomb(map);
			map = bomb(nextmap);
			if(N%4==1) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						sb.append(map[i][j]);
					}
					sb.append("\n");
				}
			} else {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						sb.append(nextmap[i][j]);
					}
					sb.append("\n");
				}
			}
		}
		System.out.println(sb);
	}
	
	private static char[][] bomb(char[][] map) {
		char[][] nextmap = new char[R][C];
		int[] dx = {1, -1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		for(int x=0;x<R;x++) {
			for(int y=0;y<C;y++) {
				if(map[x][y]=='O') nextmap[x][y] = '.';
				else {
					boolean isbomb = false;
					for(int i=0;i<4;i++) {
						int nx = x+dx[i];
						int ny = y+dy[i];
						if(nx<0||ny<0||nx>=R||ny>=C) continue;
						
						if(map[nx][ny]=='O') {
							isbomb = true;
							break;
						}
					}
					if(!isbomb) nextmap[x][y] = 'O';
					else nextmap[x][y] = '.';
				}
			}
		}
		return nextmap;
	}
}
