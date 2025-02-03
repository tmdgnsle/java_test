package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for(int tc = 1; tc <= T; tc++){
            String input = bf.readLine();
            int patternLength = findPatterLength(input);
            System.out.println("#" + tc + " " + patternLength);
        }
    }


    private static int findPatterLength(String str){
        for (int length = 1; length <= 10; length++) {
            String pattern = str.substring(0, length);
            boolean isPattern = true;

            for (int i = length; i < str.length(); i++) {
                if(i + length > str.length()) break;
                if(!pattern.equals(str.substring(i, i+length))){
                    isPattern = false;
                    break;
                }
                if(isPattern){
                    return length;
                }
            }


        }
        return str.length();
    }
}
