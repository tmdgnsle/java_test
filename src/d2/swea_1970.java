package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1970 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int[] moneys = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] rest = new int[8];
            int N = Integer.parseInt(br.readLine());

            System.out.println("#" + t);
            for (int i = 0; i < 8; i++) {
                rest[i] = N / moneys[i];
                N %= moneys[i];
                System.out.print(rest[i] + " ");
            }
            System.out.println();



        }
    }
}
