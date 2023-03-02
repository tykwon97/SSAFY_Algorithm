package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1107_리모컨_JH {

	static boolean[] visited;
	static int min;
	static int ten = 1;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int channel = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		visited = new boolean[10];
		if(n > 0)
			st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			visited[Integer.parseInt(st.nextToken())] = true;  // 망가진 버튼 표시
		}
		
		int abs = Math.abs(channel - 100);  // 시작번호인 100에서 목적지번호까지 + or - 버튼 누르는 횟수
		
		for(int i = 0; i <= 1000000; i++) {  // 500000번까지니까 -500000 부터 +500000이 가능하도록 백만
			int length = len(i);  // 0-백만까지 각 채널번호에 망가진 번호가 포함되지 않는다면 숫자를 몇번 눌러야하는지
			if(length != 0) {  // 망가진 버튼을 포함하지 않은 채널 번호일 경우
				int size = Math.abs(i-channel);  // 목적번호까지 + or -를 몇번눌러야하는지
				abs = (abs > length+size)? length+size:abs;  // 100에서 출발하는거보다 누를게 적으면 갱신
			}
		}
		
		System.out.println(abs);
	}
	
	private static int len(int channel) {
		if(channel == 0) {  // 아래조건에 포함되지 않아서 채널이 0일 경우는 빼줌
			if(visited[0])
				return 0;
			else
				return 1;
		}
		int cnt = 0;
		while(channel > 0) {
			if(visited[channel%10]) {
				return 0;
			} else {
				cnt += 1;
				channel /= 10;
			}
		}
		return cnt;
	}
}
