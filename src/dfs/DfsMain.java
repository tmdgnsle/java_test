package dfs;


import java.io.*;
import java.util.*;

public class DfsMain {
    static final int[] di = {-1, 0, 1, 0};//상우하좌
    static final int[] dj = {0, 1, 0, -1};
    static int N = 5, C = 0;
    static int[][] a;
    static boolean[][] v;

    static void dfs(int i, int j) {
        v[i][j] = true;
        a[i][j] = C++;
        for (int[] b : a) System.out.println(Arrays.toString(b));
        System.out.println();
        for (int d = 0; d < 4; d++) {
            int ni = i + di[d];
            int nj = j + dj[d];
            if (0 <= ni && ni < N && 0 <= nj && nj < N && !v[ni][nj]) {
                dfs(ni, nj);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        a = new int[N][N];
        v = new boolean[N][N];
        C = 1;
        dfs(N / 2, N / 2);
    }
}

