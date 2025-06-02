import java.io.*;
import java.util.*;

public class Main {

	static class Jewelry implements Comparable<Jewelry> {
		int m;
		int v;

		Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewelry o) {
			return Integer.compare(o.v, this.v); // 가치 내림차순
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
		TreeSet<Integer> bags = new TreeSet<>(); // 사용 가능한 가방들의 용량

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			jewelries.add(new Jewelry(m, v));
		}

		for (int i = 0; i < K; i++) {
			bags.add(Integer.parseInt(br.readLine()));
		}

		long result = 0;

		while (!jewelries.isEmpty() && !bags.isEmpty()) {
			Jewelry jewelry = jewelries.poll();

			// 현재 보석의 무게 이상인 가장 작은 용량의 가방 찾기
			Integer suitableBag = bags.ceiling(jewelry.m);

			if (suitableBag != null) {
				result += jewelry.v;
				bags.remove(suitableBag); // 사용한 가방 제거
			}
		}

		System.out.println(result);
	}
}