package gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N1043_Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean[] isKnow = new boolean[N+1]; // 진실을 알고 있는 사람들
		
		// 진실을 알고 있는 사람들 isKnow 배열에 표시
		st = new StringTokenizer(in.readLine(), " ");
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			isKnow[Integer.parseInt(st.nextToken())] = true; 
		}
		
		// 바깥 List(전체 모임 집합)
		// 안쪽 List(각 모임 하나씩)
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			num = Integer.parseInt(st.nextToken()); 
			
			boolean flag = false; // 진실을 알고 있는 사람이 있는지 확인
			List<Integer> newList = new LinkedList<>();
			for (int j = 0; j < num; j++) {
				int index = Integer.parseInt(st.nextToken());
				
				// 진실을 알고 있는 사람이 있는 경우
				if(isKnow[index]) 
					flag = true;
				
				newList.add(index);
			}
			
			if(flag) {
				// 진실을 알고 있는 사람이 있는 경우 모임 전체 인원 true로 변경
				for (int j = 0; j < newList.size(); j++) 
					isKnow[newList.get(j)] = true;
			}else {
				// 진실을 알고 있는 사람이 없는 경우 list에 추가
				list.add(newList);
			}	
		}

		// list가 진실을 모르는 사람들의 모임으로만 이루어질때까지 반복
		while(true) {
			boolean dontknow = true; // 진실을 알고 있는 사람이 없는지 체크
			
			for (int i = 0; i < list.size(); i++) {

				boolean flag = false; // 개별 모임마다 진실을 알고 있는 사람이 있는지 확인
				List<Integer> newList = list.get(i);
				
				for (int j = 0; j < newList.size(); j++) { //개별 모임 인원 체크
					int index = newList.get(j);
					if(isKnow[index]) { // 진실을 알고 있는 사람이 있다.
						flag = true;
						break;
					}
				}
				if(flag) {
					for (int j = 0; j < newList.size(); j++) {
						int index = newList.get(j);
						isKnow[index] = true;
					}
					list.remove(i);
					dontknow = false;
				}else {
					continue;
				}
			}
			if(dontknow) // 전체 모임 중 아무도 진실을 아는 사람이 없는 경우
				break;
		}
		System.out.println(list.size());
	}
}
