package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1946_Main {
	
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());	
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(in.readLine());	
			int[] students = new int[N+1];
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine(), " ");
				int documentScore = Integer.parseInt(st.nextToken());	
				int interviewScore = Integer.parseInt(st.nextToken());	
				students[documentScore] = interviewScore;
			}
			int count = selectPasser(students);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}

	private static int selectPasser(int[] students) {
		int count = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			if(students[i]<min) {
				min = students[i];
				count++;
			}
		}
		return count;
	}

}