package swea;

import java.util.*;
import java.io.*;

public class q1_0218 {
	static int[] A, B;
	static int N, P;
	static ArrayList<Integer> M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			A = new int[N];
			B = new int[N];
			M = new ArrayList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}

			find_max(A[0], 0, true);
			find_max(B[0], 0, false);

			int max = Integer.MIN_VALUE;

			for (int a : M) {
				max = Math.max(max, a);
			}

			System.out.println("#" + t + " " + max);
		}
	}

	static void find_max(int current, int depth, boolean isA) {
		if (depth == N - 1) {

			M.add(current);

		} else {
			if (isA) {
				int a = A[depth + 1] - P;
				if (a <= 0)
					a = 1;
				find_max(current + a, depth + 1, isA);
				find_max(current + B[depth + 1], depth + 1, !isA);
			} else {
				int b = B[depth + 1] - P;
				if (b <= 0)
					b = 1;
				find_max(current + A[depth + 1], depth + 1, !isA);
				find_max(current + b, depth + 1, isA);
			}
		}
	}

}
