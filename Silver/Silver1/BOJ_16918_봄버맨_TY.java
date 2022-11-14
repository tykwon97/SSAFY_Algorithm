package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16918_Main {

	public static int R;
	public static int C;
	
	public static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		

		if(N%2==0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print('O');
				}
				System.out.println();
			}
			return;
			
		}else {
			
			if((N-1)%4==2) {
				bomb();
			}else if((N-1)%4==0 && N != 1) {
				bomb();
				bomb();
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}System.out.println();
	}

	private static void bomb() {
		int[] dx = {+1,-1,+0,+0};
		int[] dy = {+0,+0,+1,-1};
		Queue<int[]> queue = new ArrayDeque<int[]>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 'O') {
					queue.add(new int[] {i,j});
					map[i][j] = '.';
				}else {
					map[i][j] = 'O';
				}
			}
		}

		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			int x = arr[0];	
			int y = arr[1];
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny<0 || nx>=R || ny>=C)
					continue;
				map[nx][ny] = '.';
			}
		}
		
	}
}