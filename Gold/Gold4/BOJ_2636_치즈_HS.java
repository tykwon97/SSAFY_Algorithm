package boj;

import java.io.*;
import java.util.*;

public class Main_G4_2636_치즈 {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;
	static int rows, cols, totalTime = 0, lastCheeze = 0;
	static ArrayList<Integer[]> meltList;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		rows = Integer.parseInt(st.nextToken());
		cols = Integer.parseInt(st.nextToken());

		map = new int[rows + 2][cols + 2]; // 가장 바깥쪽에 테두리 넣기 위해
		visited = new boolean[rows + 2][cols + 2];
		for (int i = 1; i <= rows; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= cols; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		meltList = new ArrayList<>();
		bfs(1, 1);
		int time = 1; // 기본적으로 bfs 수행하고 나면 1시간 지난 것
		
		// 시간마다 반복
		ArrayList<Integer[]> newMeltList = meltList; // bfs 돌고 얻은 meltList를 복사
		while (!meltList.isEmpty()) {
			meltList = new ArrayList<>(); // bfs 돌릴 list 초기화
			
			for (int i = 0; i < newMeltList.size(); i++) {
				Integer[] melt = newMeltList.get(i);
				bfs(melt[0], melt[1]);
			}
			
			if(meltList.isEmpty()) {
				// 다음에 녹을게 없다 -> 지금이 마지막
				lastCheeze = newMeltList.size();
				totalTime = time;
				break;
			}else {
				// 다음에 녹을게 있으면 시간 추가, 다시 bfs돌고 얻은 meltList를 복사
				time++;
				newMeltList = meltList;
			}
		}

		sb.append(totalTime).append("\n").append(lastCheeze);
		System.out.println(sb);
	}

	static void bfs(int r, int c) {
		ArrayDeque<Integer[]> queue = new ArrayDeque<>();
		queue.offer(new Integer[] { r, c });
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			
			for (int t = 0; t < size; t++) {
				Integer[] cur = queue.poll();
				r = cur[0];
				c = cur[1];

				for (int k = 0; k < 4; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];

					if (nr < 1 || nr > rows || nc < 1 || nc > cols || visited[nr][nc])
						continue;

					if (map[nr][nc] == 0) { 
						// 1 찾을 때까지 방문 체크만하고 bfs
						queue.offer(new Integer[] { nr, nc });
						visited[nr][nc] = true;
					} else { 
						// 1을 발견했으면 방문체크하고 0으로 바꾼 뒤, bfs 하지 말고!!
						// 녹을 치즈니까 meltList에 담음!
						visited[nr][nc] = true;
						map[nr][nc] = 0;
						meltList.add(new Integer[] { nr, nc }); // 녹은거 체크하려고!!
					}
				}
			}
		}
	}
}
