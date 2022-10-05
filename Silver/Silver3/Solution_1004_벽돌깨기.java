package prob.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution_1004_벽돌깨기 {
	
	static int N, W, H;
	static int ans;
	static int startRow ,startCol, startRange;
	static Deque<Integer> dq;
	static int[] dr = {0, 1, 0, -1}; // 동 남 서 북
	static int[] dc = {1, 0, -1, 0};
//	static int[][] map, tempMap;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = Integer.MAX_VALUE;
			
			mapRecursive(0, map);
			
			
//			for (int[] a: map)
//				System.out.println(Arrays.toString(a));
			if (ans == Integer.MAX_VALUE) ans = 0;
			
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
			
		} // 모든 tc 종료문
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}

	private static void mapRecursive(int cnt, int[][] map) {
		
		if (cnt == N) {
			int remainBlock = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j]==0) continue;
					++remainBlock;
				}
			}
			
//			for (int[] a: map)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
			ans = Math.min(ans, remainBlock);
			
			return;
		}
		
		for (int j = 0;j < W; j++) {
			if (getStart(j, map)) {
				startCol = j; // startRow, startCol, startRange
//				System.out.println(startRow + " : " + startCol + " : " + startRange);
				
				int[][] tempMap = new int[H][W];
				tempMap = copy(map);
				
				boolean[][] visited = new boolean[H][W];
				bombMap(startRow, startCol, startRange, map, visited);
				dropMap(map);
				
				mapRecursive(cnt+1, map);
				
				map = copy(tempMap);
				
			} else {
				continue;
			}
		}
		
	}
	
	private static void dropMap(int[][] map) {
		for (int j = 0; j < W; j++) {
			int order = H-1;
			dq = new ArrayDeque<Integer>();
			for (int i = H-1; i >= 0; i--) {
				if (map[i][j] == 0) continue;
				dq.addLast(map[i][j]);
				map[i][j] = 0;
			}
			while(!dq.isEmpty()) {
				map[order--][j] = dq.poll();
			}
		}
		
	}

	private static void bombMap(int row, int col, int range, int[][] map, boolean[][] visited) {
		map[row][col] = 0; // 현재 폭탄 위치를 0으로
		visited[row][col] = true; // 현재 폭탄 위치를 방문 처리
		
		if (range == 1 || range == 0) {
			return;
		}
		
		for (int ran = 2; ran <= range; ran++) {
			for (int k = 0; k < 4; k++) {
				int nextR = row + dr[k]*(ran-1);
				int nextC = col + dc[k]*(ran-1);
				
				if ((0<=nextR && nextR<H && 0<=nextC && nextC<W)
						&&(!visited[nextR][nextC] && map[nextR][nextC] != 0)) {
					bombMap(nextR, nextC, map[nextR][nextC], map, visited);
				}
				
				
			}
		}
		
	}

	private static boolean getStart(int j, int[][] map) {
		for (int i = 0; i < H; i++) {
			if (map[i][j] != 0) {
				startRow = i;
				startRange = map[i][j];
				return true;
			}
		}
		return false;
	}

	private static int[][] copy(int[][] map){
		int[][] temp = new int[H][W];
		for (int i=0; i < H; i++) {
			for (int j=0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		return temp;
	}

}
