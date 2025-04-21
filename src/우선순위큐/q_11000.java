package 우선순위큐;

import java.io.*;
import java.util.*;

public class q_11000 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] times = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i][0] = Integer.parseInt(st.nextToken());
			times[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(times, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}

				return o1[0] - o2[0];
			}

		});

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.offer(times[0][1]);

		for (int i = 1; i < N; i++) {
			if (times[i][0] >= pq.peek()) {
				pq.poll();
			}
			pq.offer(times[i][1]);

		}

		System.out.println(pq.size());

	}
}