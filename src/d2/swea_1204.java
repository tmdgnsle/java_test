package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] count = new int[101];

            int[] scores = new int[1000];

            for (int i = 0; i < scores.length; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            for(int score: scores){
                count[score] += 1;
            }

            int maxCounts = 0;
            int maxScore = 0;

            for (int i = 0; i < count.length; i++) {
                if (maxCounts <= count[i]){
                    maxCounts = count[i];
                    maxScore = i;
                }
            }

            System.out.println("#" + t + " " + maxScore);

        }
    }
}
