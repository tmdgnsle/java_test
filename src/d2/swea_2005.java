package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(bf.readLine());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                arr[i][0] = 1;
                for (int j = 1; j <= i; j++) {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];

                }
            }
            System.out.println("#" + t);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if(arr[i][j] > 0){
                        System.out.print(arr[i][j]+ " ");
                    } else System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
}
