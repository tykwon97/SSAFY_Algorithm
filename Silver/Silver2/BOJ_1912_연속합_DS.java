package BOJ.Sliver.Sliver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_¿¬¼ÓÇÕ {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int[] arr = new int[N];		
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] sum = new int[N];
		sum[0] = arr[0];
		int max = sum[0];
		for(int i=1;i<N;i++) {
			if(sum[i-1]+arr[i]<arr[i]) sum[i] = arr[i];
			else sum[i] = sum[i-1] + arr[i];
			max = Math.max(sum[i], max);
		}
		System.out.println(max);
	}
}
