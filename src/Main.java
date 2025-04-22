import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_14510.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int max = 0;
			int[] trees = new int[N];
			for (int i = 0; i < N; i++) {
				int tree = Integer.parseInt(st.nextToken());
				trees[i] = tree;

				max = Math.max(max, tree);
			}

			int even = 0, odd = 0;

			for (int i = 0; i < N; i++) {
				int diff = max - trees[i];

				if (diff == 0)
					continue;

				even += diff / 2;
				odd += diff % 2;
			}

			if (even > odd) {
				while (Math.abs(even - odd) > 1) {
					even -= 1;
					odd += 2;
				}
			}

			int result = 0;

			if (even > odd) {
				result = 2 * even;
			} else if (odd > even) {
				result = 2 * odd - 1;
			} else {
				result = even + odd;
			}

			System.out.println("#" + t + " " + result);

		}
	}
}