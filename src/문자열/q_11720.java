package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split("");

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(input[i]);
        }

        System.out.println(sum);
    }
}
