package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class N9375_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			
			HashMap<String, List<String>> map = new HashMap<>();
			
			int N = Integer.parseInt(in.readLine());
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(in.readLine()," ");
				String value = st.nextToken();
				String key = st.nextToken();
				if(map.get(key) == null) {
					List<String> list = new ArrayList<>();
					list.add(value);
					map.put(key, list);

				}else {
					List<String> list = map.get(key);

					if(!list.contains(key)) {
						list.add(value);
					}
				}
			}

			int num = 1;
			for(String key : map.keySet()) {
				int size = map.get(key).size();
				num *= (size+1);
			}
			num -=1;
			sb.append(num).append("\n");
		}
		System.out.println(sb);
	}
}
