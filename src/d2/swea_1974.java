package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class swea_1974 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수


        for (int t = 1; t <= T; t++) {
            int[][] grid = new int[9][9];

            StringTokenizer st;
            // 스도쿠 입력 받기
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 스도쿠 검증
            if (isValidSudoku(grid)) {
                System.out.println("#" + t + " 1");
            } else {
                System.out.println("#" + t + " 0");
            }
        }


    }

    // 스도쿠 검증 함수
    public static boolean isValidSudoku(int[][] grid) {
        // 행과 열 검증
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                // 행 체크
                if (rowCheck[grid[i][j]]) {
                    return false;
                }
                rowCheck[grid[i][j]] = true;

                // 열 체크
                if (colCheck[grid[j][i]]) {
                    return false;
                }
                colCheck[grid[j][i]] = true;
            }
        }

        // 3x3 박스 검증
        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                boolean[] boxCheck = new boolean[10];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int num = grid[boxRow + i][boxCol + j];
                        if (boxCheck[num]) {
                            return false;
                        }
                        boxCheck[num] = true;
                    }
                }
            }
        }

        return true; // 모든 조건 만족
    }
}