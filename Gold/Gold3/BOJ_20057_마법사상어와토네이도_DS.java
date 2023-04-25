package baekjoon.gold.gold3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20057_마법사상어와토네이도 {

	static int[][] map;
	static int alpa, N, ans=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] dx = {0, 1, 0, -1};
		int[] dy = {-1, 0, 1, 0};
		int x = N/2;
		int y = N/2;
		
		int n = 0;
		map[x][y] = 1;
		while(x+y>0) {
			
			for(int i=0;i<=((int) (n/2));i++) {
				
				x = x + dx[n%4];
				y = y + dy[n%4];
				
				diffusion(x, y, n%4);
				if(x==0&&y==0) break;
			}
			n++;
		}
		System.out.println(ans);
	}

	private static void diffusion(int x, int y, int d) {
		int sand = map[x][y];
		alpa = sand;
		if(d==0) {
			wind(x-2, y, sand, 0.02);
			wind(x-1, y, sand, 0.07);
			wind(x-1, y-1, sand, 0.1);
			wind(x-1, y+1, sand, 0.01);			
			wind(x, y-2, sand, 0.05);
			wind(x+1, y-1, sand, 0.1);
			wind(x+1, y, sand, 0.07);
			wind(x+1, y+1, sand, 0.01);
			wind(x+2, y, sand, 0.02);
			if(x>=N||y-1>=N||x<0||y-1<0) ans += alpa; 
			else {
				map[x][y-1] += alpa; 
			}
		} else if(d==1) {
			wind(x, y-2, sand, 0.02);
			wind(x, y-1, sand, 0.07);
			wind(x+1, y-1, sand, 0.1);
			wind(x-1, y-1, sand, 0.01);			
			wind(x+2, y, sand, 0.05);
			wind(x+1, y+1, sand, 0.1);
			wind(x, y+1, sand, 0.07);
			wind(x-1, y+1, sand, 0.01);
			wind(x, y+2, sand, 0.02);
			if(x+1>=N||y>=N||x+1<0||y<0) ans += alpa; 
			else {
				map[x+1][y] += alpa; 
			}
		} else if(d==2) {
			wind(x-2, y, sand, 0.02);
			wind(x-1, y, sand, 0.07);
			wind(x-1, y+1, sand, 0.1);
			wind(x-1, y-1, sand, 0.01);			
			wind(x, y+2, sand, 0.05);
			wind(x+1, y+1, sand, 0.1);
			wind(x+1, y-1, sand, 0.01);
			wind(x+1, y, sand, 0.07);
			wind(x+2, y, sand, 0.02);
			if(x>=N||y+1>=N||x<0||y+1<0) ans += alpa; 
			else {
				map[x][y+1] += alpa; 
			}
		} else if(d==3) {
			wind(x, y-2, sand, 0.02);
			wind(x, y-1, sand, 0.07);
			wind(x-1, y-1, sand, 0.1);
			wind(x+1, y-1, sand, 0.01);			
			wind(x-2, y, sand, 0.05);
			wind(x-1, y+1, sand, 0.1);
			wind(x, y+1, sand, 0.07);
			wind(x+1, y+1, sand, 0.01);
			wind(x, y+2, sand, 0.02);
			if(x-1>=N||y>=N||x-1<0||y<0) ans += alpa; 
			else {
				map[x-1][y] += alpa; 
			}
		}
	}

	private static void wind(int x, int y, int s, double d) {
		if(x>=N||y>=N||x<0||y<0) ans += (int) (s*d); 
		else {
			map[x][y] += (int) (s*d); 
		}
		alpa -= (int) (s*d);
	}
	
	
}
