package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            String[] numbers = new String[10];
            int[] numbers_int = new int[10];
            numbers = br.readLine().split(" ");
            for (int i = 0; i < 10; i++) {
                numbers_int[i] = Integer.parseInt(numbers[i]);
            }

            int sum = 0;
            for (int number: numbers_int){
                if (number%2 != 0){
                    sum += number;
                }
            }
            System.out.println("#"+ tc + " " + sum);
        }
    }
}
