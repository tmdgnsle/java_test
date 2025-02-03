package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            String[] alph = new String[N];
            int[] repeat = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                alph[i] = st.nextToken();
                repeat[i] = Integer.parseInt(st.nextToken());
            }

            int count = 0;

            System.out.println("#" + t);
            for (int i = 0; i < alph.length; i++) {
                for (int j = 0; j < repeat[i]; j++) {
                    System.out.print(alph[i]);
                    count++;
                    if(count == 10){
                        System.out.println();
                        count = 0;
                    }

                }
            }
            System.out.println();
        }
    }
}
