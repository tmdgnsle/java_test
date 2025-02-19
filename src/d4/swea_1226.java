package d4;

import java.io.*;
import java.util.*;

public class swea_1226 {
	static int[] di = { 0, 1, 0, -1 };
	static int[] dj = { 1, 0, -1, 0 };
	static int[][] map;
	static boolean[][] v;
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1226.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			map = new int[16][16];
			v = new boolean[16][16];
			result = 0;
			int T = Integer.parseInt(br.readLine());
			for (int i = 0; i < 16; i++) {
				String str = br.readLine();

				for (int j = 0; j < 16; j++) {
					map[i][j] = Integer.parseInt("" + str.charAt(j));
				}
			}

			DFS(1, 1);
			System.out.println("#" + t + " " + result);

		}
	}

	static void DFS(int ci, int cj) {
		if (map[ci][cj] == 3) {
			result = 1;
			return;
		}
		if (v[ci][cj] || result == 1)
			return;
		v[ci][cj] = true;

		for (int i = 0; i < 4; i++) {
			int ni = ci + di[i];
			int nj = cj + dj[i];
			if (0 <= ni && ni < 16 && 0 <= nj && nj < 16) {
				if (!v[ni][nj]) {
					if (map[ni][nj] == 0 || map[ni][nj] == 3) {

						DFS(ni, nj);
					}
				}
			}
		}

	}

}
