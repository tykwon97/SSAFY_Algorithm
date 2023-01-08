package silver1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N19621_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		List<int[]> list = new LinkedList<int[]>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			list.add(new int[] {startTime, endTime,people});
		}

		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}else {
					return o1[1]-o2[1];
				}
			}
		});
		
		List<int[]> dps = new ArrayList<>();
		
		int maxValue = Integer.MIN_VALUE;
		
		for (int[] arr : list) {
			int start = arr[0];
			int end = arr[1];
			int people = arr[2];
			
			int maxStart = Integer.MIN_VALUE;
			int maxEnd = Integer.MIN_VALUE;
			
			// 시작하기 전 dp최대값, 끝나기 전 dp최대값
			for (int i = 0; i < dps.size(); i++) {
				int[] dp = dps.get(i);
				int dpEnd = dp[0];
				int v = dp[1];

				if(dpEnd <= start) {
					int value = v;
					if(value > maxStart) {
						maxStart = value;
						maxEnd = maxStart;
					}
				}else {
					int value = v;
					if(value > maxEnd)
						maxEnd = value;	
				}
			}
			
			// 이전 dp값이 없는 경우
			if(maxStart == Integer.MIN_VALUE) {
				maxStart = 0;
			}
			
			int value = Math.max(maxStart+people, maxEnd);
			if(value > maxValue)
				maxValue = value;

			dps.add(new int[] {end,value});
		}
		
		System.out.println(maxValue);
	}
}