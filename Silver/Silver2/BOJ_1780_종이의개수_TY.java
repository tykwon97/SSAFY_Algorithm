package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1780_Main {
	
	public static int N;
	public static int[][] map;
	public static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		
		result = new int[3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		countPaper(0,0,N);
		sb.append(result[0]).append("\n").append(result[1]).append("\n").append(result[2]);
		System.out.println(sb);
		
	}

	private static void countPaper(int x, int y, int size) {
		boolean flag = true;
		int pivot = map[x][y];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(map[x+i][y+j] != pivot) {
					flag = false;
					break;
				}
			}
		}
		
		if(flag) {
			result[pivot+1]++;
			return;
		}else {
			size /= 3;
			countPaper(x, y, size);
			countPaper(x, y+size, size);
			countPaper(x, y+size*2, size);
			countPaper(x+size, y, size);
			countPaper(x+size, y+size, size);
			countPaper(x+size, y+size*2, size);
			countPaper(x+size*2, y, size);
			countPaper(x+size*2, y+size, size);
			countPaper(x+size*2, y+size*2, size);
		}
	}
}
