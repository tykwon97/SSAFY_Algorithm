package BOJ.Sliver.Sliver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class BOJ_11656_접미사배열 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S = in.readLine();
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0;i<S.length();i++) {
			arr.add(S.substring(i, S.length()));
		}
		Collections.sort(arr);
		for(int i=0;i<arr.size();i++) {
			System.out.println(arr.get(i));
		}
		
	}
}
