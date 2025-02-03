package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int result;

        if (a == b && b == c){
            result = 10000 + a * 1000;
        } else if (a == b){
            result = 1000 + a * 100;
        } else if (b == c){
            result = 1000 + b * 100;
        } else if (a == c){
            result = 1000 + a * 100;
        } else {
            result = Math.max(Math.max(a, b), c) * 100;
        }

        System.out.println(result);
    }
}
