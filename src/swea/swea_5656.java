package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class swea_5656 {

	static class Point {
		int x, y, cnt; // 벽돌의 위치, 크기

		public Point(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int N, W, H, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 구슬 던지는 횟수
			W = Integer.parseInt(st.nextToken());// 가로(열크기)
			H = Integer.parseInt(st.nextToken());// 세로(행크기)
			int[][] map = new int[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 2차원 map 입력
				// ---------INPUT END--------------------
			min = Integer.MAX_VALUE;
			drop(0, map);
			System.out.println("#" + t + " " + min);
		}
	}

	/**
	 * 구슬 떨어뜨리기 (중복 순열의 형태)
	 * 
	 * @param cnt : 떨어뜨린 구슬의 수
	 * @param map : 직전까지의 map
	 * @return
	 */
	private static boolean drop(int cnt, int[][] map) {

		// 구슬을 던지기 전에 현 상태로 남은 벽돌수 체크
		int result = getRemain(map);
		// 남은 벽돌 수가 0이면 모든 벽돌이 제거된 가장 최적의 상태이므로 최소값 0으로 갱신후 return true
		if (result == 0) {
			min = 0;
			// return;
			return true;
		}
		// 모든 구슬을 다 던졌다면 남은 벽돌수로 최소값 갱신 후 return false
		if (cnt == N) {
			if (min > result)
				min = result;
			return false;
		}

		int[][] newMap = new int[H][W];
		for (int y = 0; y < W; y++) { // 모든 열에 대해 시도

			// 해당 열에 떨어뜨릴 경우 제거되게 되는 맨 윗벽돌 찾기
			int x = 0;
			while (x < H && map[x][y] == 0)
				++x;
			// 벽돌이 존재하지 않는다면(해당 열은 모두 빈칸) 다음 열로 건너뛰기
			if (x == H)
				continue;

			// 벽돌이 존재한다면 기존 상태에서 복사
			copy(map, newMap);
			// 벽돌 제거 + 함께 제거될 인접벽돌 연쇄 찾기
			boom(newMap, x, y);
			// 제거처리(벽돌 내리기)
			down(newMap);
			// 다음 구슬 던지러 가기 : 재귀 호출 ==> 재귀호출의 결과가 true이면 가장 최적해의 상황이므로 return true
			if (drop(cnt + 1, newMap))
				return true;
		}
		return false;
	}

	// 인접한 제거 벽돌 찾기 : Flood Fill(4방 BFS)
	private static void boom(int[][] map, int x, int y) {
		Queue<Point> queue = new ArrayDeque<Point>();

		if (map[x][y] > 1)
			queue.offer(new Point(x, y, map[x][y]));
		map[x][y] = 0; // 방문 처리(벽돌 제거 표시)

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur.x;
				int ny = cur.y;
				for (int i = 1; i < cur.cnt; i++) {// cnt-1만큼 주변 벽돌 찾기
					nx += dx[d];
					ny += dy[d];
					if (isRange(nx, ny) && map[nx][ny] > 0) {
						if (map[nx][ny] > 1)
							queue.offer(new Point(nx, ny, map[nx][ny]));
						map[nx][ny] = 0; // 방문 처리
					}
				}
			}
		}
	}

	// 벽돌 내리기1 : 빈자리 위쪽 벽돌 찾아 내리기
	// 벽돌 내리기2 : 매 열마다 맨 윗행부터 벽돌칸 모두 스택에 넣고 빈칸 만들기
	private static void down(int[][] map) {
		// 매 열 기준으로 내리기
		for (int y = 0; y < W; y++) {
			int x = H - 1, nx = -1;
			while (x > 0) {
				if (map[x][y] == 0) { // 빈칸이면 내릴 벽돌 찾기
					nx = x - 1; // 바로 윗행부터 찾기

					while (nx > 0 && map[nx][y] == 0)
						--nx;

					map[x][y] = map[nx][y];
					map[nx][y] = 0; // 빈칸 처리
				}

				if (nx == 0)
					break;
				--x;
			}
		}
	}

	/**
	 * 배열 복사용 메소드
	 * 
	 * @param map
	 * @param newMap
	 */
	private static void copy(int[][] map, int[][] newMap) {
		for (int x = 0; x < H; x++) {
			for (int y = 0; y < W; y++) {
				newMap[x][y] = map[x][y];
			}
		}
	}

	private static boolean isRange(int nx, int ny) {
		return nx >= 0 && nx < H && ny >= 0 && ny < W;
	}

	/**
	 * 남은 벽돌의 수를 구하는 메소드
	 * 
	 * @param map
	 * @return
	 */
	private static int getRemain(int[][] map) {
		int cnt = 0;
		for (int x = 0; x < H; x++) {
			for (int y = 0; y < W; y++) {
				if (map[x][y] != 0)
					cnt++;
			}
		}
		return cnt;
	}

}