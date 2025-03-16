package 그리디;


import java.io.*;
import java.util.*;

public class q_1339 {
    static int N;
    static String[] words;
    static int[] alphValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        alphValue = new int[26];
        int[] weight = new int[26];
        for (String s : words) {
            int len = s.length();
            for (int i = 0; i < len; i++) {
                char c = s.charAt(i);
                weight[c - 'A'] += (int) Math.pow(10, len - i - 1);
            }
        }

        Integer[] indices = new Integer[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> weight[b] - weight[a]);

        int num = 9;

        for (int i = 0; i < 26; i++) {
            if (weight[indices[i]] > 0) {
                alphValue[indices[i]] = num--;
            }
        }

        long sum = 0;
        for (String s : words) {
            long wordSum = 0;
            for (int i = 0; i < s.length(); i++) {
                wordSum = wordSum * 10 + alphValue[s.charAt(i) - 'A'];
            }
            sum += wordSum;
        }

        System.out.println(sum);

    }
}
