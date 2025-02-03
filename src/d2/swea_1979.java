package d2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수


        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 퍼즐의 크기
            int K = Integer.parseInt(st.nextToken()); // 단어의 길이

            int[][] puzzle = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            // 가로 방향 검사
            for (int i = 0; i < N; i++) {
                int length = 0; // 연속된 흰색 칸의 길이
                for (int j = 0; j < N; j++) {
                    if (puzzle[i][j] == 1) {
                        length++;
                    } else {
                        if (length == K) count++;
                        length = 0;
                    }
                }
                if (length == K) count++; // 줄이 끝난 후에도 확인
            }

            // 세로 방향 검사
            for (int j = 0; j < N; j++) {
                int length = 0; // 연속된 흰색 칸의 길이
                for (int i = 0; i < N; i++) {
                    if (puzzle[i][j] == 1) {
                        length++;
                    } else {
                        if (length == K) count++;
                        length = 0;
                    }
                }
                if (length == K) count++; // 열이 끝난 후에도 확인
            }

            System.out.println("#" + t + " " + count);

        }


    }
}