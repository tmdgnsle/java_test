package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();

        String[] str = input.split(" ");

        if(input.equals("")) {
            System.out.println(0);
        } else{
            System.out.println(str.length);
        }


    }
}
