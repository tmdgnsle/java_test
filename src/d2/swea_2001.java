package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t= 1; t<= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 배열 크기 N
            int M = Integer.parseInt(st.nextToken()); // 파리채 크기 M

            int[][] grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = catchFlies(grid,M);

            System.out.println("#" + t + " " + result);

        }
    }

    private static int catchFlies(int[][] arr, int M){
        int maxFlies = 0;
        for (int i = 0; i < arr.length - M; i++) {
            for (int j = 0; j < arr.length - M; j++) {
                int sum = 0;
                for (int x = 0; x < M; x++) {
                    for (int y = 0; y < M; y++) {
                        sum += arr[i + x][j + y];
                    }
                }
                maxFlies = Math.max(maxFlies, sum);
            }
        }
        return maxFlies;
    }
}
