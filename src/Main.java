//  스타트와 링크

import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int[][] arr;
    static boolean[] v;
    static int min;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = N / 2;
        arr = new int[N + 1][N + 1];
        v = new boolean[N + 1];
        min = Integer.MAX_VALUE;
        result = new ArrayList<Integer>();
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bt();

        System.out.println(min);

    }

    static void bt() {
        if (result.size() == M) {
            int sum = 0;
            int ops = 0;
            int[] op = new int[N];
            for (int i = 0; i < N; i++) {
                op[i] = i + 1;
            }
            for (int i = 0; i < M; i++) {
                int num = result.get(i);
                for (int j = 0; j < M; j++) {
                    int num2 = result.get(j);
                    sum += arr[num][num2];
                }
                op[num - 1] = 0;
            }
            for (int i = 0; i < N; i++) {
                int op1 = op[i];
                if (op1 != 0) {
                    for (int j = 0; j < N; j++) {
                        int op2 = op[j];
                        if (op2 != 0) {
                            ops += arr[op1][op2];
                        }

                    }
                }
            }

            min = Math.min(min, Math.abs(sum - ops));

            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!v[i]) {
                v[i] = true;
                result.add(i);

                bt();

                v[i] = false;
                result.remove(result.size() - 1);
            }
        }


    }


}