package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1058_친구_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer>[] arrlist = new ArrayList[N];  // 관계 표시할 2차원 AL
		boolean[] visited = new boolean[N];
		int[] ans = new int[N];
		for(int i = 0; i < N; i++) {
			arrlist[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < N; j++) {
				if(str.charAt(j)=='Y') {  // 친구인사람들
					arrlist[i].add(j);
				}
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < arrlist[i].size(); j++) {
//				System.out.print(arrlist[i].get(j));
//			} System.out.println();
//		}
//		System.out.println();
//		
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {  // 처음부터 끝까지 순회
			int cnt = arrlist[i].size();  // 직접 친구인 사람 수로 초기화
//			System.out.println("i : " + i + "cnt : "+ cnt);
			for(int j = 0; j < arrlist[i].size(); j++) {  // 일단 큐에 넣구!
				queue.add(arrlist[i].get(j));
				visited[arrlist[i].get(j)] = true;  // 방문체크
			}
			
			while(!queue.isEmpty()) {
				int num = queue.poll();
//				System.out.print("i : " + i + " " + "num : " + num);
				for(int j = 0; j < arrlist[num].size(); j++) {  // 인접 친구의 직접친구
					if(!visited[arrlist[num].get(j)] && arrlist[num].get(j) != i) { // 방문된게 아니라면 + 내 자신이 아니라면
						cnt++;  // 카운트 해줌
//						System.out.println(arrlist[num].get(j));
						visited[arrlist[num].get(j)] = true;
					}
				}
			}
//			System.out.println(cnt);
			ans[i] = cnt;  // 2-친구수 설정
			queue.clear();  // 큐 초기화
			Arrays.fill(visited, false);
		}
		Arrays.sort(ans);
		System.out.println(ans[ans.length-1]);
	}
	
}
