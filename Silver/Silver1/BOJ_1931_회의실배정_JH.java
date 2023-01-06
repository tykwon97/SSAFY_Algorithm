package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정_JH {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int[][] arr = new int[N][2];
	    for(int i = 0; i < N; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	arr[i][0] = Integer.parseInt(st.nextToken());
	    	arr[i][1] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr, new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
	    	
	    });
	    
	    int min = arr[0][1];
	    int cnt = 1;
	    for(int i = 1; i < N; i++) {
	    	if(min < arr[i][0]) {
	    		cnt++;
	    		min = arr[i][1];
	    	}
	    }
	    
	    System.out.println(cnt);
	}
}
