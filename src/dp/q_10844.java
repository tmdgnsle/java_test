package dp;

import java.io.*;
import java.util.*;

public class q_10844 {
	static long mod = 1000000000;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long D[][] = new long[N + 1][11];
		for (int i = 1; i <= 9; i++) {
			D[1][i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			D[i][0] = D[i - 1][1];
			D[i][9] = D[i - 1][8];
			for (int j = 1; j <= 8; j++) {
				D[i][j] = (D[i - 1][j - 1] + D[i - 1][j + 1]) % mod;
			}
		}
		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + D[N][i]) % mod;
		}

		System.out.println(sum);
	}
}
