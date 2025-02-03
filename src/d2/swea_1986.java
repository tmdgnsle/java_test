package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<= T; t++){
            int n = Integer.parseInt(br.readLine());

            int result = 0;
            for (int i = 1; i <= n; i++) {
                if(i %2 == 0){
                    result -= i;
                } else{
                    result += i;
                }
            }
            System.out.println("#" + t + " " + result);
        }
    }
}
