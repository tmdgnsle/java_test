package 그리디;

import java.io.*;
import java.util.*;

public class q_14247 {
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		long result = 0;

		for (int i = 0; i < n; i++) {
			result += Integer.parseInt(st.nextToken());
		}

		int[] growth = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			growth[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(growth);

		for (int i = 0; i < n; i++) {
			result += i * growth[i];
		}

		System.out.println(result);

	}
}