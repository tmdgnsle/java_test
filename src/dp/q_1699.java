package dp;

import java.io.*;
import java.util.*;

public class q_1699 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}

		System.out.println(dp[N]);

	}
}