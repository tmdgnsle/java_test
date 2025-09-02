package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2096 {

    static int[][] board;
    static int min;
    static int max;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        board = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
            }
        }

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < 3; i++) {
            simulate(0, i, board[0][i]);
        }

        System.out.println(max + " " + min);

    }

    static void simulate(int x, int y, int sum) {
        if (x == n - 1) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        simulate(x + 1, y, sum + board[x + 1][y]);
        if (y <= 1) {
            simulate(x + 1, y + 1, sum + board[x + 1][y + 1]);
        }
        if (y >= 1) {
            simulate(x + 1, y - 1, sum + board[x + 1][y - 1]);
        }

    }

}
