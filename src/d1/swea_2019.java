package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2019 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i <= n; i++) {
            int result = 1;
            for (int j = 0; j < i; j++) {
                result *=2;
            }
            System.out.print(result + " ");
        }
    }
}
