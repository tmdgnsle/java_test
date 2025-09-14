package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class q_2292 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(1);
            return;
        }

        int layer = 1;
        int maxRoom = 1;

        while (maxRoom < N) {
            maxRoom += 6 * layer;
            layer++;
        }

        System.out.println(layer);
    }
}
