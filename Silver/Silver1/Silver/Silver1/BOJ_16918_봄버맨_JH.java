package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨_JH {

	static int R,C,N,cnt;
	static char[][] arr;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new int[R][C];
		for(int i = 0; i < R; i++) {
			Arrays.fill(visited[i], -1);			
		}
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
			for(int j = 0; j < C; j++) {
				if(arr[i][j] == 'O') {
					visited[i][j] = cnt;  // 폭탄설치 시점(초기 0)
				}
			}
		}
		cnt++;
		while(true) {
			if(cnt == N)
				break;
			set();
			if(cnt == N)
				break;
			bomb();
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}System.out.println();
		}
		
	}
	public static void set() {
		cnt++;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j]!='O') {
					visited[i][j] = cnt;  // 폭탄 설치 시점
					arr[i][j] = 'O';
				}
			}
		}
	}
	
	public static void bomb() {
		cnt++;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(visited[i][j]+3 == cnt) {  // 3초전 폭탄 터짐
					arr[i][j] = '.';
					visited[i][j] = -1;
					for(int k = 0; k < 4; k++) {  // 인접 지점 터짐
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx>=0 && nx < R && ny>=0 && ny < C && (visited[nx][ny]+3 != cnt)) {
							arr[nx][ny] = '.';
							visited[nx][ny] = -1;
						}
					}
				}
			}
		}
	}
}
