package d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea_2058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄: 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        // 각 달의 일수를 배열로 정의 (1~12월, 2월은 윤년 고려하지 않음)
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


        // 테스트 케이스 처리
        for (int t = 1; t <= T; t++) {
            String date = br.readLine();

            // 연, 월, 일을 추출
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));

            // 유효성 검사
            if (month >= 1 && month <= 12 && day >= 1 && day <= daysInMonth[month - 1]) {
                // 날짜가 유효한 경우 출력 형식 설정
                System.out.println("#" + t + " " + String.format("%04d/%02d/%02d", year, month, day));

            } else {
                // 날짜가 유효하지 않은 경우
                System.out.println("#" + t + " -1");
            }
        }
    }
}