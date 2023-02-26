package BOJ.Sliver.Sliver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_9375_ÆÐ¼Ç¿Õ½ÅÇØºó {

	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		
		for(int tc=0;tc<T;tc++) {
			int n = Integer.parseInt(in.readLine());
			int answer = 1;
			HashMap<String, Integer> items = new HashMap<>();
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				st.nextToken();
				String name = st.nextToken();
				if(items.containsKey(name)) items.put(name, items.get(name)+1);
				else items.put(name, 1);
			}
			for(String key : items.keySet()) {
				answer *= (items.get(key)+1);
			}
			answer-=1;
			sb.append(answer).append("\n");
		
		}
		System.out.println(sb);
	}
}
