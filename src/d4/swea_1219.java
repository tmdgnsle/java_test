package d4;

import java.util.*;
import java.io.*;

public class swea_1219 {
	static List<Integer>[] map;
	static boolean[] visited;
	static int result;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1219.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			map = new ArrayList[100];
			result = 0;
			for (int i = 0; i < 100; i++) {
				map[i] = new ArrayList<Integer>();
			}

			visited = new boolean[100];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int p1 = Integer.parseInt(st.nextToken());
				int p2 = Integer.parseInt(st.nextToken());
				map[p1].add(p2);
			}

			DFS(0);

			System.out.println("#" + t + " " + result);

		}
	}

	static void DFS(int start) {
		if (start == 99) {
			result = 1;
			return;
		}
		if (visited[start])
			return;

		visited[start] = true;

		for (int next : map[start]) {
			if (!visited[next])
				DFS(next);
		}

	}
}
