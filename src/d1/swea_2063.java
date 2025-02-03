package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_2063 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        String[] input = bf.readLine().split(" ");
        int[] numbers = new int[N];
        for (int i = 0; i < input.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int[] sortedArr = Arrays.stream(numbers).sorted().toArray();

        System.out.println(sortedArr[N/2]);
    }
}
