
package dfs;

import java.io.*;
import java.util.*;

class q_2458 {
	static ArrayList<int[]> A;
	static int[] child, parent;
	static boolean[] v;
	static int N, M, current;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
//		StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st = null;
// N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
			A = new ArrayList<>();
			child = new int[N + 1];
			parent = new int[N + 1];
			v = new boolean[N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				A.add(new int[] { a, b });
			}
			int count = 0;
			for (int i = 1; i <= N; i++) {
				current = i;
				DFS(i);
				BDFS(i);

				if (child[i] + parent[i] == N - 1) {
					count++;
				}

				for (int j = 0; j <= N; j++) {
					v[j] = false;
				}

			}

			System.out.println("#" + t + " " + count);
//		System.out.println(count);

		}
	}

	static void DFS(int num) {
		v[num] = true;
		for (int[] a : A) {
			if (a[0] == num) {
				if (!v[a[1]]) {
					child[current]++;
					DFS(a[1]);
				}
			}
		}

	}

	static void BDFS(int num) {
		v[num] = true;
		for (int[] a : A) {
			if (a[1] == num) {
				if (!v[a[0]]) {
					parent[current]++;
					BDFS(a[0]);
				}
			}
		}
	}

}
