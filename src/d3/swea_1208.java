package d3;

import java.util.*;
import java.io.*;

public class swea_1208 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1208.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] A = new int[100];
			for (int i = 0; i < 100; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				int max_index = 0;
				int min_index = 0;
				for (int j = 0; j < 100; j++) {
					if (A[max_index] < A[j]) {

						max_index = j;
					}
					if (A[min_index] > A[j]) {

						min_index = j;
					}
				}

				if (A[max_index] == A[min_index] || A[max_index] - A[min_index] == 1) {
					break;
				}

				A[max_index]--;
				A[min_index]++;
			}
			int max = Integer.MIN_VALUE;

			int min = Integer.MAX_VALUE;

			for (int j = 0; j < 100; j++) {
				if (max < A[j]) {
					max = A[j];
				}
				if (min > A[j]) {
					min = A[j];
				}
			}
			int result = max - min;
			System.out.println("#" + t + " " + result);

		}

	}

}
