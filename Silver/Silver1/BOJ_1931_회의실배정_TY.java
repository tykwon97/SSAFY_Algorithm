package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N1931_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		List<int[]> list = new LinkedList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int startTime = Integer.parseInt(st.nextToken());
			int endTime = Integer.parseInt(st.nextToken());	
			list.add(new int[] {startTime, endTime});
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

		int count = 0;
		int prevEndTime = -1;
		for (int[] arr : list) {
			//			System.out.println(Arrays.toString(arr));
			int startTime = arr[0];
			int endTime = arr[1];

			if(prevEndTime<=startTime) {
				count++;
				prevEndTime = endTime;
			}
		}
		System.out.println(count);
	}
}
