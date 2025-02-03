package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2025 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int sum = 0;
        for (int i = 0; i < n + 1; i++) {
            sum += i;
        }

        System.out.println(sum);
    }
}
