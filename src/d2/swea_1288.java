package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class swea_1288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<= T; t++){
            int N = Integer.parseInt(br.readLine());
            System.out.println("#" + t + " " + getNumber(N));
        }
    }

    private static int getNumber(int n) {
        boolean[] numbers = new boolean[10];
        int k =1;
        while (!allTrue(numbers)) {
            int count = k * n;
            while (count > 0){
                if(!numbers[count % 10]) numbers[count%10] = true;
                count /= 10;
            }
            k++;
        }
        return (k-1)*n;
    }

    public static boolean allTrue(boolean[] arr) {
        for (boolean b : arr) {
            if (!b) {
                return false;  // 하나라도 false가 있으면 false를 반환
            }
        }
        return true;  // 모든 값이 true일 경우 true를 반환
    }
}
