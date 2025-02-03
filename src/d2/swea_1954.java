package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine()); // 달팽이 크기 입력
            int[][] arr = new int[N][N];

            // 방향 벡터 (우, 하, 좌, 상)
            int[] xdir = {0, 1, 0, -1};
            int[] ydir = {1, 0, -1, 0};

            int x = 0, y = 0, dir = 0; // 초기 위치 및 방향
            int count = 1; // 채울 숫자

            // 달팽이 숫자 채우기
            while (count <= N * N) {
                arr[x][y] = count++; // 현재 위치에 숫자 할당

                int nx = x + xdir[dir];
                int ny = y + ydir[dir];

                // 경계 초과 또는 이미 채워진 경우 방향 전환
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] != 0) {
                    dir = (dir + 1) % 4; // 방향 전환
                    nx = x + xdir[dir];
                    ny = y + ydir[dir];
                }

                x = nx;
                y = ny;
            }

            // 결과 출력
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j]);
                    if (j < N - 1) System.out.print(" "); // 마지막 열 제외 공백 출력
                }
                System.out.println();
            }
        }

        br.close();
    }
}