package SSAFY_Algorithm.Gold.Gold5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20055_컴베이어벨트위의로봇_DS {
	static int[] A;
	static int N, K, time;
	static belt[] belts;
	static ArrayList<Integer> robot;
	static class belt {
		int hp;
		boolean isRobot;
		public belt(int hp, boolean isRobot) {
			super();
			this.hp = hp;
			this.isRobot = isRobot;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belts = new belt[2*N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<2*N;i++) {
			belts[i] = new belt(Integer.parseInt(st.nextToken()), false);
		}
		robot = new ArrayList<>();
		time = 0;
		while(checkHp()<K) {
			time++;
			cycle();
			moveRobot();
			upRobot();

		}
		System.out.println(time);
	}
	static void check() {
		System.out.println("#"+time + " ");
		for(int i=0;i<2*N;i++) {
			System.out.print(belts[i].hp + " ");
		}System.out.println();
		for(int i=0;i<2*N;i++) {
			System.out.print(belts[i].isRobot+ " ");
		}System.out.println();
	}
	static int checkHp() {
		int sum=0;
		for(int i=0;i<2*N;i++) {
			if(belts[i].hp==0) sum+=1;
		}
		return sum;
	}
	static void moveRobot() {
		for(int i=N-2;i>0;i--) {
			if(belts[i].isRobot && !belts[i+1].isRobot && belts[i+1].hp>0) {
				belts[i+1].hp--;
				belts[i+1].isRobot = true;
				belts[i].isRobot = false;
			}
		}
		downRobot();
	}
	static void upRobot() {
		if(belts[0].hp!=0) {
			belts[0].isRobot=true;
			belts[0].hp--;
		}
	}
	static void downRobot() {
		if(belts[N-1].isRobot) {
			belts[N-1].isRobot = false;
		}
	}
	static void cycle() {
		belt temp = belts[2*N-1];
		for(int i=2*N-1;i>0;i--) {
			belts[i] = belts[i-1];
		}
		belts[0] = temp;
		downRobot();
	}
}
