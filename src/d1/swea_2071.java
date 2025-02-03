package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String[] numbers = bf.readLine().split(" ");
            int[] numbers_int = new int[10];
            for (int i = 0; i < numbers.length; i++) {
                numbers_int[i] = Integer.parseInt(numbers[i]);
            }

            // 평균 계산
            double mean = Arrays.stream(numbers_int).sum() / 10.0;

            // 소수점 첫 번째 자리에서 반올림
            int roundedMean = (int) Math.round(mean);

            System.out.println("#" + tc + " " + roundedMean);
        }
    }
}