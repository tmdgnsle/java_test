package swea;


import java.io.*;
import java.util.*;

public class swea_5656 {

    static class Point {
        int r, c, cnt;

        public Point(int r, int c, int cnt) {
            super();
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, W, H, min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            int[][] map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            drop(0, map);
            System.out.println("#" + t + " " + min);
        }
    }

    static boolean drop(int cnt, int[][] map) {
        int result = getRemain(map);
        if (result == 0) {
            min = 0;
            return true;
        }

        if (cnt == N) {
            if (min > result) min = result;
            return false;
        }

        int[][] newMap = new int[H][W];
        for (int c = 0; c < W; c++) {
            int r = 0;
            while (r < H && map[r][c] == 0) ++r;
            if (r == H) continue;

            copy(map, newMap);
            boom(newMap, r, c);
            down(newMap);
            if (drop(cnt + 1, newMap)) return true;
        }

        return false;

    }

    static void boom(int[][] map, int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();

        if (map[r][c] > 1) queue.offer(new Point(r, c, map[r][c]));
        map[r][c] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur.r;
                int nc = cur.c;
                for (int i = 1; i < cur.cnt; i++) {
                    nr += dr[d];
                    nc += dc[d];
                    if (isRange(nr, nc) && map[nr][nc] > 0) {
                        if (map[nr][nc] > 1) queue.offer(new Point(nr, nc, map[nr][nc]));
                        map[nr][nc] = 0;
                    }
                }
            }
        }
    }

    static void down(int[][] map) {
        for (int c = 0; c < W; c++) {
            int r = H - 1, nr = -1;
            while (r > 0) {
                if (map[r][c] == 0) {
                    nr = r - 1;

                    while (nr > 0 && map[nr][c] == 0) --nr;

                    map[r][c] = map[nr][c];
                    map[nr][c] = 0;
                }

                if (nr == 0) break;
                --r;
            }
        }
    }

    static void copy(int[][] map, int[][] newMap) {
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                newMap[r][c] = map[r][c];
            }
        }
    }

    static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < H && nc >= 0 && nc < W;
    }

    static int getRemain(int[][] map) {
        int cnt = 0;
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (map[r][c] != 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
