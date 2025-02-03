package string_q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int max = 0;
        int max_index = 0;
        int second = 0;
        s = s.toUpperCase();
        int[] alpha = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 65] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if(second < alpha[i]){
                if(max < alpha[i]){
                    max_index = i;
                    second = max;
                    max = alpha[i];
                } else {
                    second = alpha[i];
                }
            }
        }

        if(max == second){
            System.out.println('?');
        } else{
            char c = (char) (max_index + 65);
            System.out.println(c);
        }
    }
}
