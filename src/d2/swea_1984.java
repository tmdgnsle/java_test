package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1984 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수 입력
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // 각 테스트 케이스의 숫자들 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

            // 배열에 값 저장 및 합계, 최소값, 최대값 계산
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
                max = Math.max(max, arr[i]);
                min = Math.min(min, arr[i]);
            }

            // 최대값과 최소값 제외한 합계
            int adjustedSum = sum - max - min;

            // 평균 계산 (소수점 첫째 자리 반올림)
            int average = Math.round((float) adjustedSum / 8);

            // 결과 출력
            System.out.println("#" + t + " " + average);
        }
    }
}