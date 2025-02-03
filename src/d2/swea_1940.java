package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int speed = 0;
            int distance = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    speed += Integer.parseInt(st.nextToken());
                    distance += speed;
                }
                if (a == 2) {
                    speed -= Integer.parseInt(st.nextToken());
                    if (speed < 0) {
                        speed = 0;
                    }
                    distance += speed;
                }
                if (a == 0) {
                    distance += speed;
                }
            }

            System.out.println("#" + t + " " + distance);
        }
    }
}
