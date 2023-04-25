package prob.study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_15654_N과M5_SK_s3 {
	
	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		arr = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		perm(0);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	private static void perm(int cnt) {
		
		if (cnt == M) {
			for (int a: arr)
				sb.append(a).append(" ");
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			arr[cnt] = list.get(i);
			visited[i] = true;
			perm(cnt+1);
			visited[i] = false;
			
		}
		
	}

}
