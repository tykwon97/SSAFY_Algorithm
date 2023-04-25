package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1946_신입사원_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {  // 테케 수
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n][2];
			for(int i = 0; i < n; i++) {  // 입력받기
				st = new StringTokenizer(br.readLine());
				int temp1 = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());
				arr[i][0] = temp1;
				arr[i][1] = temp2;
			}
			
			Arrays.sort(arr, new Comparator<int[]>() {  // 2차원 배열 정렬

				@Override
				public int compare(int[] o1, int[] o2) {  // 첫원소 기준 오름차순
					return o1[0]-o2[0];
				}
				
			});
			int cnt = 0; // 불합자수
			int min = arr[0][1]; // 서류1등의 면접등수
			for(int i = 1; i < n; i++) {  // 서류 1등은 제외
				if(arr[i][1] > min) {  // 면접등수 낮으면
					cnt++;  // 불합
				} else {
					min = arr[i][1];  // 본인보다 서류등수가 높은 사람들 중 가장 최고 면접 등수
				}
			}
			int ans = n - cnt;
			System.out.println(ans);
		}
	}
}
