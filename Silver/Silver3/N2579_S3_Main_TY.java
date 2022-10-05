package gold1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1194_Solution {
	
	public static int N;
	public static int M;
	public static char[][] map;
	public static int[][] cnt;
	public static int dx[] = {1,0,0,-1};
	public static int dy[] = {0,1,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		int sx=-1, sy=-1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '0') {
					sx = i;
					sy = j;
				}
			}
		}
		
		miro(sx,sy);
	}

	private static void miro(int sx, int sy) {
		PriorityQueue<String[]> queue = new PriorityQueue<>(new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int i1 = Integer.parseInt(o1[2]);
				int i2 = Integer.parseInt(o2[2]);
				return i1-i2;
			}
		});
		
		queue.offer(new String[]{sx+"",sy+"","0",""});
		map[sx][sy] = '.';
		
		while(!queue.isEmpty()) {
			String[] arr = queue.poll();
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			int count = Integer.parseInt(arr[2]);
			String op = arr[3];
			char[] option = op.toCharArray();
			Arrays.sort(option);
			op = new String(option);
			
//			System.out.println(Arrays.toString(map[0]));
			for (int i = 0; i < 4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M)
					continue;

//				System.out.println("x : "+ nx +" y : "+ny+" count : "+count);
				
				if(map[nx][ny] == '.') {
					queue.offer(new String[]{nx+"",ny+"",(count+1)+"", op});
					
				}else if('a' <= map[nx][ny] && map[nx][ny] <= 'f') {

					boolean flag = true;
					for (int j = 0; j < op.length(); j++) {
						char k = op.charAt(j);
						if(map[nx][ny] == k) {
							flag = false;
							break;
						}
					}
					if(flag)
						queue.offer(new String[]{nx+"",ny+"",(count+1)+"", op+map[nx][ny]});
					else
						queue.offer(new String[]{nx+"",ny+"",(count+1)+"", op});
					
				}else if('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
					
					boolean flag = false;
					for (int j = 0; j < op.length(); j++) {
						char k = op.charAt(j);
						if((map[nx][ny]+32) == k) {
							flag = true;
							break;
						}
					}
					if(flag)
						queue.offer(new String[]{nx+"",ny+"",(count+1)+"", op+map[nx][ny]});
					
				}else if(map[nx][ny] == '1') {
					System.out.println(count+1);
					return;
				}
			}
		}
		System.out.println("-1");
		return;
	}
}
