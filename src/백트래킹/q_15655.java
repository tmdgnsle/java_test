package 백트래킹;

import java.io.*;
import java.util.*;

public class q_15655 {
	static int[] nums;
	static int N, M;
	static boolean[] v;
	static ArrayList<Integer> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		v = new boolean[N];
		result = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		bt(0);

		System.out.println(sb);

	}

	static void bt(int current) {
		if (result.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				if (nums[i] > current) {
					v[i] = true;
					result.add(nums[i]);

					bt(nums[i]);

					v[i] = false;
					result.remove(result.size() - 1);

				}
			}
		}

	}
}
