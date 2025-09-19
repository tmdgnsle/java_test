package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q_2493 {


    static class Razer {
        int razer;
        int idx;

        public Razer(int razer, int idx) {
            this.razer = razer;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] razers = new int[n + 1];
        Stack<Razer> temp = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            razers[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n + 1];

        for (int i = n; i >= 1; i--) {
            if (temp.isEmpty()) {
                temp.add(new Razer(razers[i], i));
            } else {
                if (temp.peek().razer > razers[i]) {
                    temp.push(new Razer(razers[i], i));
                    continue;
                }
                while (!temp.isEmpty() && temp.peek().razer < razers[i]) {
                    Razer current = temp.pop();
                    result[current.idx] = i;
                }
                temp.push(new Razer(razers[i], i));
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
