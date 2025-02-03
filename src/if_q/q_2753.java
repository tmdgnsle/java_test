package if_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(br.readLine());

        int result;

        if((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))){
            result = 1;
        } else {
            result = 0;
        }

        System.out.println(result);
    }
}
