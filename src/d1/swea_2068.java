package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc ++){
            String[] input = br.readLine().split(" ");
            int[] numbers = new int[10];
            for (int i = 0; i < input.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }

            int max = numbers[0];

            for(int number: numbers){
                max = Math.max(max, number);
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}
