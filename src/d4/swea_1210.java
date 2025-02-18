package d4;

import java.util.*;
import java.io.*;

public class swea_1210 {
	static int[][] map;
	static boolean[][] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1210.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			int T = Integer.parseInt(br.readLine());
			map = new int[100][100];

			// 입력
			for (int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 도착지점(2) 찾기
			int endCol = 0;
			for (int j = 0; j < 100; j++) {
				if (map[99][j] == 2) {
					endCol = j;
					break;
				}
			}

			// 도착지점에서 위로 올라가면서 경로 찾기
			int row = 99;
			int col = endCol;

			while (row > 0) {
				// 왼쪽에 길이 있는 경우
				if (col - 1 >= 0 && map[row][col - 1] == 1) {
					col--;
					while (col > 0 && map[row][col - 1] == 1) {
						col--;
					}
				}
				// 오른쪽에 길이 있는 경우
				else if (col + 1 < 100 && map[row][col + 1] == 1) {
					col++;
					while (col < 99 && map[row][col + 1] == 1) {
						col++;
					}
				}
				row--;
			}

			result = col;
			System.out.println("#" + t + " " + result);
		}
	}
}