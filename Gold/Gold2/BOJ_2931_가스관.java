package baekjoon.gold.gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2931_가스관 {

	static class point {
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static point p;  // 현재 위치한 곳
	static point from; // 전에 위치했던 곳
	static char[][] map;
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1;tc<=T;tc++) {
			flag = true;
			sb.append("#").append(tc).append(" ");
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			for(int i=0;i<R;i++) {
				String str = in.readLine();
				for(int j=0;j<C;j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='M') {  // M에서 시작하므로 시작지점 저장합니다.
						p = new point(i, j);
						from = new point(i, j);
					}
				}
			}
			
			int[] dx = {1, -1, 0, 0};
			int[] dy = {0, 0, 1, -1};
			for(int i=0;i<4;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0||ny<0||nx>=R||ny>=C||map[nx][ny]=='.') continue;
				
				p.x = nx;  // 집과 유치원은 하나의 블록과 인접해있는 경우만 입력하므로 도로를 만나면 바로 이동합니다.
				p.y = ny;
				break;
			}
			
			while(flag) move();  // 도로가 없을 때 까지 계속 이동합니다.
			sb.append(p.x+1).append(" ").append(p.y+1).append(" "); // 빈 도로를 출력에 저장합니다.
			
			boolean[] isRoad = new boolean[4];
			for(int i=0;i<4;i++) {      // 주변에 도로가 있는지 탐색합니다.
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(nx<0||ny<0||nx>=R||ny>=C||map[nx][ny]=='.') continue;
				
				char com = map[nx][ny];
				if(i==0&&(com=='|'||com=='+'||com=='2'||com=='3')) {  // 위로 이동 가능한 도로 이면 true
					isRoad[i] = true;
				} else if(i==1&&(com=='|'||com=='+'||com=='1'||com=='4')) { // 아래로 이동 가능한 도로 이면 true
					isRoad[i] = true;
				} else if(i==2&&(com=='-'||com=='+'||com=='3'||com=='4')) { // 오른쪽으로 이동 가능한 도로 이면 true
					isRoad[i] = true;
				} else if(i==3&&(com=='-'||com=='+'||com=='1'||com=='2')) { // 왼쪽으로 이동 가능한 도로 이면 true
					isRoad[i] = true;
				}
			}
			if(isRoad[0]&&isRoad[1]&&isRoad[2]&&isRoad[3]) { // 4방향으로 갈수있는 도로가 모두있으면 +
				sb.append('+').append("\n");
			} else if(isRoad[0]&&isRoad[2]) {  // 2방향 도로를 이어줄수 있는 도로를 찾습니다.
				sb.append('1').append("\n");
			} else if(isRoad[1]&&isRoad[2]) {
				sb.append('2').append("\n");
			} else if(isRoad[1]&&isRoad[3]) {
				sb.append('3').append("\n");
			} else if(isRoad[0]&&isRoad[3]) {
				sb.append('4').append("\n");
			} else if(isRoad[3]&&isRoad[2]) {
				sb.append('-').append("\n");
			} else if(isRoad[1]&&isRoad[0]) {
				sb.append('|').append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static void move() {  // 도로가 없을 때 까지 계속 이동합니다.
		char com = map[p.x][p.y]; // 도로의 상태를 확인합니다.
		if(com=='.') { // 도로가 없으면
			flag = false;
		} else if(com=='|') {  // 전에 있던 곳과 현재있는 곳을 비교해서 갈 방향을 정합니다.
			if(p.x > from.x) {           // 위에서 밑으로
				p.x++;
				from.x++;
			} else if(p.x < from.x) {   // 아래에서 위로
				p.x--;
				from.x--;
			}
		} else if(com=='-') {
			if(p.y > from.y) {         // ->
				p.y++;
				from.y++;
			} else if(p.y < from.y) {   // <-
				p.y--;
				from.y--;
			}
		}else if(com=='+') {
			if(p.x > from.x) {           // 위에서 밑으로
				p.x++;
				from.x++;
			} else if(p.x < from.x) {   // 아래에서 위로
				p.x--;
				from.x--;
			} else if(p.y > from.y) {         // ->
				p.y++;
				from.y++;
			} else if(p.y < from.y) {   // <-
				p.y--;
				from.y--;
			}
		} else if(com=='1') {
			if(p.x < from.x) {   // 아래에서 위로
				p.y++;
				from.x--;
			} else if(p.y < from.y) {   // <-
				p.x++;
				from.y--;
			}
		} else if(com=='2') {
			if(p.x > from.x) {           // 위에서 밑으로
				p.y++;
				from.x++;
			} else if(p.y < from.y) {   // <-
				p.x--;
				from.y--;
			}
		} else if(com=='3') {
			if(p.y > from.y) {         // ->
				p.x--;
				from.y++;
			} else if(p.x > from.x) {           // 위에서 밑으로
				p.y--;
				from.x++;
			}
		} else if(com=='4') {
			if(p.y > from.y) {         // ->
				p.x++;
				from.y++;
			} else if(p.x < from.x) {   // 아래에서 위로
				p.y--;
				from.x--;
			}
		}
	}
}
