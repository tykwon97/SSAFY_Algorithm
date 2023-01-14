package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2630_Main {
	public static int whitePaper;
	public static int bluePaper;
	public static boolean[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					map[i][j] = true;
				}
			}
		}
		
		bfs(0,0,N);
		
		System.out.println(bluePaper);
		System.out.println(whitePaper);
	}

	private static void bfs(int x, int y, int size) {
		boolean flag = true;
		boolean firstValue = map[x][y];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(i==0 && j==0) continue;
				if(firstValue != map[x+i][y+j]) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			if(firstValue)
				whitePaper++;
			else
				bluePaper++;
			return;
		}else {
			size = size/2;
			bfs(x,y,size);
			bfs(x+size,y,size);
			bfs(x,y+size,size);
			bfs(x+size,y+size,size);
		}
	} 
}
