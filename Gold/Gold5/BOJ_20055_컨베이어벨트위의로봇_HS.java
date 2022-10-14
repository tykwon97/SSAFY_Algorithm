package algo_study;

import java.io.*;
import java.util.*;

public class Main_G5_20055_컨베이어벨트위의로봇 {
	static int N, K;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 컨베이어 벨트 길이
		K = Integer.parseInt(st.nextToken()); // 내구도 0인 칸 개수 제한

		arr = new int[2 * N];
		ArrayList<Integer> list = new ArrayList<>();
		HashMap<Integer, Integer> existed = new HashMap<>();

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 2 * N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int upIdx = 0; // 올리는 인덱스
		int downIdx = N - 1; // 내리는 인덱스
		int count = 0, time = 0;
		while (true) {
			time++;
			
			// 컨베이어벨트 1만큼 이동
			if (--upIdx == -1)
				upIdx = 2 * N - 1;
			if (--downIdx == -1)
				downIdx = 2 * N - 1;
			
			// 내리는 위치라면 내려야함
			if (!list.isEmpty()) {
				if (list.get(0) == downIdx) {
					existed.remove(list.get(0));
					list.remove(0);
				}
			}

			// 로봇 이동
			ArrayList<Integer> newList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				int pos = list.get(i);
				if (++pos == 2 * N) {
					pos = 0;
				}
				if (!existed.containsKey(pos) && arr[pos] > 0) {
					// 이동 가능
					newList.add(pos);
					existed.put(pos, 0);
					existed.remove(list.get(i));
					if(--arr[pos] == 0) count++;
				}else {
					// 이동 불가능하면 그대로 다시 추가
					newList.add(list.get(i));
				}
			}
			if (!newList.isEmpty())
				list = newList;

			// 내리는 위치라면 내려야함
			if (!list.isEmpty()) {
				if (list.get(0) == downIdx) {
					existed.remove(list.get(0));
					list.remove(0);
				}
			}
			
			// 올리기
			if(arr[upIdx] > 0) {
				list.add(upIdx);
				existed.put(upIdx, 0);
				if(--arr[upIdx] == 0) count++;
			}
			
			if(count >= K) break;
		}
		
		System.out.println(time);
	}
}
