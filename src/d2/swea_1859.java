package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= T; tc ++){
            int N = Integer.parseInt(bf.readLine());

            String[] input = bf.readLine().split(" ");
            int[] numbers = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                numbers[i] = Integer.parseInt(input[i]);
            }

            int maxNumber = numbers[N-1];
            long maxProfit = 0;

            for (int i = N-1; i >= 0; i--) {
                if(numbers[i] > maxNumber){
                    maxNumber = numbers[i];
                } else {
                    maxProfit += maxNumber - numbers[i];
                }
            }

            System.out.println("#" + tc + " " + maxProfit);
        }
    }
}
