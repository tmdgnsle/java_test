package 시뮬레이션;

import java.io.*;
import java.util.*;

public class q_2578 {
	static int count;
	static int count_b;
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		count = 0;
		count_b = 0;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int p = Integer.parseInt(st.nextToken());
				count++;
				bingo(p);
				if (count_b >= 3)
					break;
			}
			if (count_b >= 3)
				break;
		}

		System.out.println(count);

	}

	static void bingo(int p) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (board[i][j] == p) {
					x = i;
					y = j;
					board[i][j] = 0;
				}
			}
		}

		boolean row = true;
		boolean col = true;

		for (int i = 0; i < 5; i++) {
			if (board[x][i] != 0) {
				row = false;
				break;
			}
		}

		if (row)
			count_b++;

		for (int i = 0; i < 5; i++) {
			if (board[i][y] != 0) {
				col = false;
				break;
			}
		}

		if (col)
			count_b++;

		if (x == y) {
			boolean cross = true;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (i == j) {
						if (board[i][j] != 0) {
							cross = false;
							break;
						}
					}
				}
			}

			if (cross)
				count_b++;

		}

		if (x + y == 4) {
			boolean cross = true;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (i + j == 4) {
						if (board[i][j] != 0) {
							cross = false;
							break;
						}
					}
				}
			}

			if (cross)
				count_b++;

		}

	}

}