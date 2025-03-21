package 백트래킹;


import java.io.*;
import java.util.*;

public class q_2580 {
    static int[][] board;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solveSudoku(0, 0);

    }

    static void solveSudoku(int row, int col) {
        if (col == 9) {
            solveSudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }


        if (board[row][col] != 0) {
            solveSudoku(row, col + 1);
            return;
        }


        for (int i = 1; i <= 9; i++) {
            if (isValid(row, col, i)) {
                board[row][col] = i;
                solveSudoku(row, col + 1);
                board[row][col] = 0;
            }
        }
    }

    static boolean isValid(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
            if (board[i][col] == num) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return false;
            }
        }

        return true;
    }

}