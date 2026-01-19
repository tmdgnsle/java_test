package 그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1205 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newScore = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());


        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        int rank = 1;
        for (int i = 0; i < N; i++) {
            if (scores[i] > newScore) {
                rank++;
            } else {
                break;
            }
        }


        if (rank > P || (N == P && newScore <= scores[N - 1])) {
            System.out.println(-1);
        } else {
            System.out.println(rank);
        }
    }
}
