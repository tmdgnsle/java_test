package dp;

import java.io.*;
import java.util.*;

public class q_1149 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] price = new int[N][3];
		int[][] dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
				if (i == 0)
					dp[i][j] = price[i][j];
			}
		}

		for (int i = 1; i < N; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + price[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + price[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + price[i][2];
		}

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N - 1][i]);
		}

		System.out.println(min);

	}
}