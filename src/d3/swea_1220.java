package d3;

import java.util.*;
import java.io.*;

public class swea_1220 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1220.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine()); // 테이블 한 변의 길이
			int[][] table = new int[N][N];

			StringTokenizer st;
			// 테이블 정보 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int deadlock = 0; // 교착 상태 카운트

			// 각 열을 검사
			for (int j = 0; j < N; j++) {
				int state = 0; // 상태 변수 (0: 초기상태, 1: N극 발견)

				// 위에서 아래로 검사
				for (int i = 0; i < N; i++) {
					if (table[i][j] == 1) { // N극(빨간색)
						state = 1;
					} else if (table[i][j] == 2) { // S극(파란색)
						if (state == 1) { // N극을 만난 후 S극을 만나면 교착상태
							deadlock++;
							state = 0;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + deadlock);
		}

		br.close();
	}
}