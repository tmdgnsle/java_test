package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1936 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bf.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if ((a==1 && b == 3) || (a == 2 && b == 1) || (a == 3 && b == 2)){
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}
