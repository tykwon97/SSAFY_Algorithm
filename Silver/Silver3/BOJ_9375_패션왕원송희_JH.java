package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕원송희_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> map = new HashMap<>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();  // 버리는 문자~
				String key = st.nextToken();
				if(map.containsKey(key)) {
					map.put(key, map.get(key)+1);
				} else {
					map.put(key, 1);
				}
			}
			
			int res = 1;
			
			for(String key : map.keySet()) {
				res *= (map.get(key) + 1);
			}
			
			System.out.println(res-1);
			
			
		}
	}
}
