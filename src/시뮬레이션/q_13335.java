package 시뮬레이션;

import java.io.*;
import java.util.*;

public class q_13335 {
	static int n, w, L;
	static Queue<Integer> trucks;
	static int time;

	public static void main(String[] args) throws Exception {
		trucks = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trucks.add(Integer.parseInt(st.nextToken()));
		}

		time = 0;
		simulate();

		System.out.println(time);

	}

	static void simulate() {
		Deque<Truck> bridge = new LinkedList<>();

		while (!bridge.isEmpty() || !trucks.isEmpty()) {
			int next = 0;
			if (!trucks.isEmpty()) {
				next = trucks.peek();
			}
			int sum = 0;
			boolean exit = false;
			for (Truck t : bridge) {
				if (t.time + 1 >= w) {
					exit = true;
				} else {
					t.setTime();
					sum += t.weight;
				}
			}

			if (exit) {
				bridge.pollFirst();
			}

			if (next != 0) {
				if (sum + next <= L) {
					bridge.add(new Truck(trucks.poll(), 0));
				}
			}

			time++;

		}

	}

}

class Truck {
	int weight;
	int time;

	Truck(int weight, int time) {
		this.weight = weight;
		this.time = time;
	}

	void setTime() {
		this.time += 1;
	}

}