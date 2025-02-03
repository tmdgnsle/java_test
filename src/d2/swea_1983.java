package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class swea_1983 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        // 학점 배열
        String[] grades = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for (int t = 1; t <= T; t++) {
            // 입력 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 학생 수
            int K = Integer.parseInt(st.nextToken()); // 학점을 알고 싶은 학생 번호

            double[][] scores = new double[N][2]; // 점수와 인덱스를 저장 (총점, 원래 인덱스)

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                double mid = Double.parseDouble(st.nextToken()) * 0.35; // 중간고사 (35%)
                double finals = Double.parseDouble(st.nextToken()) * 0.45; // 기말고사 (45%)
                double homework = Double.parseDouble(st.nextToken()) * 0.20; // 과제 (20%)
                scores[i][0] = mid + finals + homework; // 총점 계산
                scores[i][1] = i + 1; // 학생 번호 저장 (1부터 시작)
            }

            // 총점을 기준으로 내림차순 정렬
            Arrays.sort(scores, Comparator.comparingDouble(o -> -o[0]));

            // K번째 학생의 학점을 찾기
            int studentsPerGrade = N / 10; // 한 학점당 학생 수
            int kIndex = 0;

            for (int i = 0; i < N; i++) {
                if ((int) scores[i][1] == K) { // K번째 학생 찾기
                    kIndex = i;
                    break;
                }
            }

            // 학점 계산
            String grade = grades[kIndex / studentsPerGrade];

            // 출력
            System.out.println("#" + t + " " + grade);
        }
    }
}