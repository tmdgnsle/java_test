package 반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_10431 {

    static int P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int count = 0;
            int[] order = new int[20];
            for (int j = 0; j < 20; j++) {
                int height = Integer.parseInt(st.nextToken());
                int nextIdx = j;
                for (int k = 0; k < j; k++) {
                    if (order[k] > height) {
                        nextIdx = k;
                        break;
                    }
                }

                if (nextIdx != j) {
                    for (int k = j; k > nextIdx; k--) {
                        order[k] = order[k - 1];
                        count++;
                    }
                }
                order[nextIdx] = height;
            }

            System.out.println(T + " " + count);
        }
    }
}
