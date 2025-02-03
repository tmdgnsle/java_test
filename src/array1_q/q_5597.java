package array1_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] chool = new boolean[31];

        for (int i = 0; i < 28; i++) {
            int number = Integer.parseInt(br.readLine());

            chool[number] = true;
        }

        for (int i = 1; i < 31; i++) {
            if(!chool[i]) System.out.println(i);
        }
    }
}
