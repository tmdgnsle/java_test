package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1945 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[5];

            while (N%2 == 0){
                N /=2;
                arr[0] += 1;
            }
            while (N%3 == 0){
                N /=3;
                arr[1] += 1;
            }
            while (N%5 == 0){
                N /=5;
                arr[2] += 1;
            }
            while (N%7 == 0){
                N /=7;
                arr[3] += 1;
            }
            while (N%11 == 0){
                N /=11;
                arr[4] += 1;
            }

            System.out.print("#" + t + " ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
