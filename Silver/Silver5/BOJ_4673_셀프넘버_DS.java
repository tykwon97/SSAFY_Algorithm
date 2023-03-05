package BOJ.Sliver.Sliver5;

public class BOJ_4673_¼¿ÇÁ³Ñ¹ö {

	public static void main(String[] args) {
		boolean[] isNotSelf = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			int N = i;
			int sum = N;
			while(N>0) {
				sum += N % 10;
				N /= 10;
			}
			if(sum<10001) isNotSelf[sum] = true;
		}
		for (int i = 1; i < 10001; i++) {
			if(!isNotSelf[i]) System.out.println(i);
		}
	}
}
