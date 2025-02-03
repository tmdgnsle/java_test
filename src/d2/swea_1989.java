package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_1989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<= T; tc++){
            String input = br.readLine();

            boolean result = isRepeat(input);

            System.out.println("#" + tc + " " + (result ? 1 : 0));
        }
    }

    private static boolean isRepeat(String str){

        for (int i = 0; i < str.length() /2 + 1; i++) {
            if(str.charAt(i) != str.charAt(str.length() -i -1)){
                return false;
            }
        }

        return true;
    }
}
