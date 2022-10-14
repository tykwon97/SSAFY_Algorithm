package ty_algo_study;

import java.io.*;
import java.util.*;

public class Main_G4_1043_거짓말 {
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int M = Integer.parseInt(st.nextToken()); // 파티의 수

		Map<Integer, Integer> knowList = new HashMap<>();
		parent = new int[N];
		make(N);

		st = new StringTokenizer(br.readLine(), " ");
		int truthNum = Integer.parseInt(st.nextToken());
		Map<Integer, Integer> truthList = new HashMap<>();
		int[] truthArr = new int[truthNum];
		for (int i = 0; i < truthNum; i++) {
			int member = Integer.parseInt(st.nextToken()) - 1;
			truthList.put(member, 0);
			truthArr[i] = member;
		}

		// 파티멤버 저장
		int[][] partyArr = new int[M][];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int partyNum = Integer.parseInt(st.nextToken());
			partyArr[i] = new int[partyNum];

			for (int k = 0; k < partyNum; k++) {
				partyArr[i][k] = Integer.parseInt(st.nextToken()) - 1;
			}
		}

		if (truthNum == 0)
			System.out.println(M);
		else {
			// 진실 공유
			if (truthNum >= 2) {
				for (int i = 1; i < truthNum; i++) {
					union(truthArr[i - 1], truthArr[i]);
				}
			}
			knowList.put(find(truthArr[0]), 0); // 진실 다 공유했으므로 가장 상위 부모 저장

			// 파티 다 돌면서 공유멤버 합치기..
			for (int i = 0; i < M; i++) {
				for (int j = 1; j < partyArr[i].length; j++) {
					union(partyArr[i][j - 1], partyArr[i][j]);
				}
			}

			// 진실 공유한 멤버의 부모를 다시 추가함! (union 과정에서 추가되면서 변경됐을 수 있으므로)
			if (!knowList.containsKey(find(truthArr[0])))
				knowList.put(find(truthArr[0]), 0);

			// 파티 다 돌면서 정답을 아는사람이 있는가 확인하기
			int count = 0;
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < partyArr[i].length; j++) {
					if (knowList.containsKey(find(partyArr[i][j]))) { // 서로 진실을 공유했다면 최상위 부모가 knowList에 있을 것이므로
						break;
					}

					if (j == partyArr[i].length - 1) // 파티 멤버 모두 최상위 부모가 knowList(진실 공유한 사람들의 부모)에 없으므로 count++;
						count++;
				}
			}
			System.out.println(count);
		}
	}

	static void make(int N) {
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}

	static int find(int a) {
		if (parent[a] == a)
			return a;
		return find(parent[a]);
	}

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a > b)
			parent[b] = a;
		else
			parent[a] = b;
	}
}
