package repeat_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int n = N / 4;

        for (int i = 0; i < n; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
