package baekjoon.sliver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991_트리순회 {
	static class bTree {
		int n;
		int left;
		int right;
		public bTree(int n,int left, int right) {
			super();
			this.n = n;
			this.left = left;
			this.right = right;
		}
	}
	static StringBuilder sb;
	static bTree[] bts;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		bts = new bTree[N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int n = st.nextToken().charAt(0) - 'A';
			int l = st.nextToken().charAt(0) - 'A';
			int r = st.nextToken().charAt(0) - 'A';
			bts[n] = new bTree(n, l, r);
		}
		preorder(0);
		sb.append("\n");
		inorder(0);
		sb.append("\n");
		postorder(0);
		sb.append("\n");
		System.out.println(sb);
		
		
	}
	
	private static void preorder(int n) {
		sb.append((char)(bts[n].n + 'A'));
		if(bts[n].left>=0) preorder(bts[n].left);
		if(bts[n].right>=0) preorder(bts[n].right);
	}
	
	private static void inorder(int n) {
		if(bts[n].left>=0) inorder(bts[n].left);
		sb.append((char)(bts[n].n + 'A'));
		if(bts[n].right>=0) inorder(bts[n].right);
	}
	
	private static void postorder(int n) {
		if(bts[n].left>=0) postorder(bts[n].left);
		if(bts[n].right>=0) postorder(bts[n].right);
		sb.append((char)(bts[n].n + 'A'));
	}

}
