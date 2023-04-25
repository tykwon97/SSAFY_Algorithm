package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_2407_조합_JH {
   
   // nCm = n!/(n-r)!*r!

   static int N, M;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      
      BigInteger n1 = BigInteger.ONE;
      BigInteger n2 = BigInteger.ONE;
      
      for(int i = 0; i < M; i++) {
         n1 = n1.multiply(new BigInteger(String.valueOf(N-i))); // n!/(n-r)!
         n2 = n2.multiply(new BigInteger(String.valueOf(i+1))); // r!
      }
      
      BigInteger answer = n1.divide(n2);
      
      System.out.println(answer);
      
   }
   
}