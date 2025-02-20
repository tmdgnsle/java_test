package 그리디;

import java.io.*;
import java.util.*;

public class q_1715 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int sum = 0;
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		while (pq.size() != 1) {

			int a = pq.poll(); // 가장 작은 카드 묶음
			int b = pq.poll(); // 두 번째로 작은 카드 묶음
			sum += a + b; // 현재 비교 횟수를 더함
			pq.add(a + b);

			System.out.println(sum);
		}
	}
}
