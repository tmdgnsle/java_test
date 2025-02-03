package d1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class swea_2050 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 문자열
        String input = br.readLine();



        // 각 문자를 숫자로 변환
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // 알파벳은 'A'~'Z'로 제한, 1~26으로 변환
            int number = ch - 'A' + 1;
            System.out.print(number + " ");

        }



    }
}