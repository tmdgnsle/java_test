package dp;

import java.io.*;
import java.util.*;

public class q_9461 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] d = new long[101];

		d[1] = 1;
		d[2] = 1;
		d[3] = 1;
		d[4] = 2;
		d[5] = 2;

		for (int i = 6; i <= 100; i++) {
			d[i] = d[i - 1] + d[i - 5];
		}

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			System.out.println(d[n]);
		}

	}
}