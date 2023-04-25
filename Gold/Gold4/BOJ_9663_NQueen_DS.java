package BOJ.Gold.Gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
    public static int[] arr;
    public static int N;
    public static int count = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {

        if (depth == N) {
            count++;
            return;
        }
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }
    public static boolean Possibility(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i]) {
                return false;
            }
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
                return false;
            }
        }
        return true;
    }
}
