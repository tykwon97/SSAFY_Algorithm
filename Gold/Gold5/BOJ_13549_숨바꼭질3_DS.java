	package BOJ.Gold.Gold5;
	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;
	
	public class BOJ_13549_¼û¹Ù²ÀÁú3 {
	
		public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] dp = new int[100001];
			
			for(int i=0;i<N+1;i++) {
				dp[i] = N-i;
			}
			for(int i=N+1;i<=K;i++) {
				if(i%2==0) dp[i] = Math.min(dp[i/2], dp[i-1]+1);
				else {
					dp[i] = Math.min(Math.min(dp[(i-1)/2], dp[(i+1)/2]) +1, dp[i-1] +1);
				}
			}
			System.out.println(dp[K]);
		}
	}
