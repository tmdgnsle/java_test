package 부분집합;

import java.io.*;
import java.util.*;

public class SubsMain {
    static int N = 4, C = 0;
    static int[] a = {1, 2, 3, 4};
    static boolean[] v = new boolean[N];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        C = 0;
        subs(0, "");
        System.out.println(C);
    }

    static void subs(int cnt, String str) { // cnt는 visited배열의 index이기도 하다
        if (cnt == N) { // 종료조건
//            System.out.println(Arrays.toString(v)); C++;
//            for (int i = 0; i < N; i++) {
//                System.out.print(v[i] ? a[i] : "_");
//            }
//            System.out.println(); C++;
            System.out.println(str); C++;
            return;
        }
        // 재귀호출
//        v[cnt] = false; // 선택하지 않고
        subs(cnt + 1, str+a[cnt]);
//        v[cnt] = true; // 선택하고
        subs(cnt + 1, str + "_");


    }
}
