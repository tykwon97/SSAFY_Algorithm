package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class N2931_Main {
	public static int R;
	public static int C;
	public static int roadX;
	public static int roadY;
	public static String operation;
	public static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C]; // 통로

		for (int j = 0; j < R; j++) { // 통로 입력받기
			map[j] = in.readLine().toCharArray();
		}
		
		int spotX = -1, spotY = -1;

		for (int j = 0; j < R; j++) {
			for (int k = 0; k < C; k++) {
				if('M'==map[j][k] || 'Z'==map[j][k]){ // 집과 유치원 위치 중 하나 저장
					spotX = j;
					spotY = k;
					break;
				}
			}
		}

		// 지워진 위치
		roadX = -1;
		roadY = -1;
		
		// 지워진 그림
		operation = "$";

		bfs(spotX,spotY);

		sb.append(roadX+1).append(" ").append(roadY+1).append(" ").append(operation).append("\n");

		System.out.println(sb);
	}

	private static void bfs(int startX, int startY) {
		Queue<int[]> queue = new ArrayDeque<>();

		int[] dx = {-1,+0,+1,+0};
		int[] dy = {+0,+1,+0,-1};

		//출발 위치에서 갈 수 있는 곳
		for (int i = 0; i < 4; i++) { 
			int nx = startX+dx[i];
			int ny = startY+dy[i];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C) //범위를 벗어난 경우
				continue;
			
			if(map[nx][ny] == 'M' || map[nx][ny] == 'Z' || map[nx][ny] == '.') //통로가 아닌 경우
				continue;
			
			queue.add(new int[] {nx,ny,startX,startY});
		}

		while(!queue.isEmpty()) {
			
			int[] xy = queue.poll();
			
			int x = xy[0];
			int y = xy[1];
			
			int prevx = xy[2];
			int prevy = xy[3];
			
			char op = map[x][y];
			
			switch (op+"") {
			
			case ".":
				
				// 지워진 위치 도착
				roadX = x;
				roadY = y;
				
				// 통로가 연결될 위치 확인
				boolean[] spotCheck = new boolean[4]; //위 오 아 왼

				for (int i = 0; i < 4; i++) {
					int nx = x+dx[i];
					int ny = y+dy[i];
					
					if(nx<0 || ny<0 || nx>=R || ny>=C)
						continue;
					
					if((map[nx][ny]=='#') || (map[nx][ny]=='.') || (map[nx][ny]=='M') || (map[nx][ny]=='Z'))  // 통로가 아닌 경우
						continue;
					
					// 가능한 경우의 수 (현재 위치와 가스관 방향)
					if(i==0 && (map[nx][ny]=='-' || map[nx][ny]=='2' || map[nx][ny]=='3')) {
						continue;
					}else if(i==1 && (map[nx][ny]=='|' || map[nx][ny]=='1' || map[nx][ny]=='2')) {
						continue;
					}else if(i==2 && (map[nx][ny]=='-' || map[nx][ny]=='1' || map[nx][ny]=='4')) {
						continue;
					}else if(i==3 && (map[nx][ny]=='|' || map[nx][ny]=='3' || map[nx][ny]=='4')) {
						continue;
					}
					
					spotCheck[i] = true; // 연결 할 통로가 있는 경우
				}
				
				// 알맞은 통로 찾기
				if(spotCheck[0] && spotCheck[1] && spotCheck[2] && spotCheck[3])
					operation = "+";
				else if(spotCheck[0] && spotCheck[1])
					operation = "2";
				else if(spotCheck[0] && spotCheck[2])
					operation = "|";
				else if(spotCheck[0] && spotCheck[3])
					operation = "3";
				else if(spotCheck[1] && spotCheck[2])
					operation = "1";
				else if(spotCheck[1] && spotCheck[3])
					operation = "-";
				else if(spotCheck[2] && spotCheck[3])
					operation = "4";
				return;
				
			case "|":
				if(prevx == x-1 && x+1<R)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && x-1>=0)
					queue.add(new int[] {x-1,y,x,y});
				break;
			case "-":
				if(prevy == y-1 && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				if(prevy == y+1 && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			case "+":
				if(prevx == x-1 && x+1<R)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && x-1>=0)
					queue.add(new int[] {x-1,y,x,y});
				if(prevy == y-1 && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				if(prevy == y+1 && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			case "1":
				if(prevy == y+1 && x+1<R)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1 && y+1<C) 
					queue.add(new int[] {x,y+1,x,y});
				break;
			case "3":
				if(prevy == y-1 && x-1>=0 )
					queue.add(new int[] {x-1,y,x,y});
				if(prevx == x-1 && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			case "2":
				if(prevx == x-1 && y+1<C)
					queue.add(new int[] {x,y+1,x,y});
				if(prevy == y+1 && x-1>=0) 
					queue.add(new int[] {x-1,y,x,y});
				break;
			case "4":
				if(prevy == y-1 && x+1<R)
					queue.add(new int[] {x+1,y,x,y});
				if(prevx == x+1  && y-1>=0)
					queue.add(new int[] {x,y-1,x,y});
				break;
			default: 
				break;
			}
		}
	}
}
