package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

public class swea_1928 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 테스트 케이스 수
        int T = Integer.parseInt(br.readLine());

        // 입력: 각 테스트 케이스에 대해 Base64로 인코딩된 문자열을 디코딩
        for (int t = 1; t <= T; t++) {
            // Base64로 인코딩된 문자열
            String encodedString = br.readLine();

            // Base64 디코딩
            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);


            // 디코딩된 바이트 배열을 문자열로 변환
            String decodedString = new String(decodedBytes);

            // 결과 출력
            System.out.println("#" + t + " " + decodedString);
        }
    }
}
