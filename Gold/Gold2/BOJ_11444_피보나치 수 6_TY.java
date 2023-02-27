package gold2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11444_Main {
	 public static final long q = 1_000_000_007; //Quotient
	 public static long[][] initMatrix = {{1,1},{1,0}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		long N = Long.parseLong(in.readLine());
		long result = 0;
		
		if(N==0) {
			System.out.println(0);
			return;
		}else if(N==1) {
			System.out.println(1);
			return;
		}else if(N==2) {
			System.out.println(1);
			return;
		}
		
		long[][] lastMatrix = matrixPowerN(N-2, initMatrix); //행렬 n승
		
		result = (lastMatrix[0][0] + lastMatrix[0][1])%q;
		System.out.println(result);
	}

	private static long[][] matrixPowerN(long n, long[][] matrix) {
		if(n==1) {
			return matrix;
		}
		if(n%2 == 0) {
			long[][] prevMatrix = matrixPowerN(n/2, matrix);

			long[][] newMatrix1 = new long[2][2];
			newMatrix1[0][0] = ((prevMatrix[0][0] * prevMatrix[0][0])%q + (prevMatrix[0][1] * prevMatrix[1][0])%q)%q;
			newMatrix1[0][1] = ((prevMatrix[0][0] * prevMatrix[0][1])%q + (prevMatrix[0][1] * prevMatrix[1][1])%q)%q;
			newMatrix1[1][0] = ((prevMatrix[1][0] * prevMatrix[0][0])%q + (prevMatrix[1][1] * prevMatrix[1][0])%q)%q;
			newMatrix1[1][1] = ((prevMatrix[1][0] * prevMatrix[0][1])%q + (prevMatrix[1][1] * prevMatrix[1][1])%q)%q;
//			System.out.println(n+" ====================1");
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(newMatrix1[i][j]+" ");
//				}System.out.println();
//			}
			return newMatrix1;
		}else {
			long[][] prevMatrix = matrixPowerN(n/2, matrix);
//			System.out.println(n+" prevMatrix====================2-1");
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(prevMatrix[i][j]+" ");
//				}System.out.println();
//			}
			long[][] newMatrix1 = new long[2][2];
			newMatrix1[0][0] = ((prevMatrix[0][0] * prevMatrix[0][0])%q + (prevMatrix[0][1] * prevMatrix[1][0])%q)%q;
			newMatrix1[0][1] = ((prevMatrix[0][0] * prevMatrix[0][1])%q + (prevMatrix[0][1] * prevMatrix[1][1])%q)%q;
			newMatrix1[1][0] = ((prevMatrix[1][0] * prevMatrix[0][0])%q + (prevMatrix[1][1] * prevMatrix[1][0])%q)%q;
			newMatrix1[1][1] = ((prevMatrix[1][0] * prevMatrix[0][1])%q + (prevMatrix[1][1] * prevMatrix[1][1])%q)%q;
//			System.out.println(n+" matrix====================2-2");
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(newMatrix1[i][j]+" ");
//				}System.out.println();
//			}
			long[][] newMatrix2 = new long[2][2];
			newMatrix2[0][0] = ((newMatrix1[0][0] * initMatrix[0][0])%q + (newMatrix1[0][1] * initMatrix[1][0])%q)%q;
			newMatrix2[0][1] = ((newMatrix1[0][0] * initMatrix[0][1])%q + (newMatrix1[0][1] * initMatrix[1][1])%q)%q;
			newMatrix2[1][0] = ((newMatrix1[1][0] * initMatrix[0][0])%q + (newMatrix1[1][1] * initMatrix[1][0])%q)%q;
			newMatrix2[1][1] = ((newMatrix1[1][0] * initMatrix[0][1])%q + (newMatrix1[1][1] * initMatrix[1][1])%q)%q;
			
//			System.out.println(n+" newMatrix====================2-3");
//			for (int i = 0; i < 2; i++) {
//				for (int j = 0; j < 2; j++) {
//					System.out.print(newMatrix2[i][j]+" ");
//				}System.out.println();
//			}
			return newMatrix2;
		}
	}

}
