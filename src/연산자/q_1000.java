package 연산자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        System.out.println(Integer.parseInt(input[0]) + Integer.parseInt(input[1]));
    }
}
