package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회_JH {

	static int n;
	static StringBuilder sb;
	static ArrayList<Character> list;
	static char[][] arr;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		sb = new StringBuilder();
		arr = new char[n][3];
		visited = new boolean[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken().charAt(0);
			arr[i][1] = st.nextToken().charAt(0);
			if(arr[i][1] == '.')
				visited[i][1] = true;
			arr[i][2] = st.nextToken().charAt(0);
			if(arr[i][2] == '.')
				visited[i][2] = true;
			list.add(arr[i][0]);
		}
		preorder(0);
		System.out.println();
		inorder(0);
		System.out.println();
		postorder(0);
	}

	private static void preorder(int depth) {
		if(arr[depth][1] == '.' && arr[depth][2] == '.') {  // 자식 없으면 본인 출력하고 리턴
			System.out.print(arr[depth][0]);
			return;
			
		}
		System.out.print(arr[depth][0]);
		if(arr[depth][1] != '.')
			preorder(list.indexOf(arr[depth][1]));
		if(arr[depth][2] != '.')
			preorder(list.indexOf(arr[depth][2]));
		
	}

	private static void inorder(int depth) {
		if(arr[depth][1] == '.' && arr[depth][2] == '.') {  // 자식 없으면 본인 출력하고 리턴
			System.out.print(arr[depth][0]);
			return;
		} else {
			if(visited[depth][1] && visited[depth][2]) {
				System.out.print(arr[depth][0]);
				return;				
			}
				
		}
		if(arr[depth][1] != '.') {
			inorder(list.indexOf(arr[depth][1]));
			visited[depth][1] = true;
		}
		System.out.print(arr[depth][0]);
		if(arr[depth][2] != '.') {
			inorder(list.indexOf(arr[depth][2]));
			visited[depth][2] = true;
			
		}
		
	}
	
	private static void postorder(int depth) {
		if(arr[depth][1] == '.' && arr[depth][2] == '.') {  // 자식 없으면 본인 출력하고 리턴
			System.out.print(arr[depth][0]);
			return;
			
		} else {
			
		}
		if(arr[depth][1] != '.')
			postorder(list.indexOf(arr[depth][1]));
		if(arr[depth][2] != '.')
			postorder(list.indexOf(arr[depth][2]));
		System.out.print(arr[depth][0]);
		
	}
}
