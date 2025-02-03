package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int number = i;
            while(number > 0){
                String str = String.valueOf(number%10);
                if(str.contains("3") || str.contains("6") || str.contains("9")){
                    sb.append("-");
                }
                number /= 10;
            }
            if(sb.isEmpty()){
                System.out.print(i + " ");
            } else {
                System.out.print(sb + " ");
            }

        }
    }
}
