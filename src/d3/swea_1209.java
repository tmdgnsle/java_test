package d3;

import java.util.*;
import java.io.*;

public class swea_1209 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1209.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			int[][] A = new int[100][100];
			int col_max = Integer.MIN_VALUE;
			int row_max = Integer.MIN_VALUE;
			int cross1 = 0;
			int cross2 = 0;

			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					A[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				int sRow = 0;
				int sCol = 0;
				for (int j = 0; j < 100; j++) {
					if (i == j) {
						cross1 += A[i][j];
					}
					if (i + j == 99) {
						cross2 += A[i][j];
					}
					sRow += A[i][j];
					sCol += A[j][i];
				}
				col_max = Math.max(col_max, sCol);
				row_max = Math.max(row_max, sRow);
				
			}

			int max = Math.max(cross1, cross2);
			max = Math.max(row_max, max);
			max = Math.max(col_max, max);
			System.out.println("#" + t + " " + max);
		}

	}
}
