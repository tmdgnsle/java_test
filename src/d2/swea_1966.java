package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class swea_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<= T; t++){
            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");

            int[] arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            int[] sortedArr = Arrays.stream(arr).sorted().toArray();

            System.out.print("#" + t);
            for (int i = 0; i < sortedArr.length; i++) {
                System.out.print(" " + sortedArr[i]);
            }
            System.out.println();
        }
    }
}
