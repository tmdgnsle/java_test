package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스의 개수 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // 각 테스트 케이스에서 두 수를 입력받음
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            // 두 수를 비교하여 결과를 저장

            if (a < b) {
                System.out.println("#" + t + " <");
            } else if (a > b) {
                System.out.println("#" + t + " >");
            } else {
                System.out.println("#" + t + " =");
            }
        }


    }
}