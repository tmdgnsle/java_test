package 스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            left.push(c);
        }
        for (int i = 0; i < N; i++) {
            String[] request = br.readLine().split(" ");
            switch (request[0]) {
                case "L":
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if(!right.isEmpty()) left.push(right.pop());
                    break;
                case "B":
                    if(!left.isEmpty()) left.pop();
                    break;
                case "P":
                    left.push(request[1].charAt(0));
                    break;
            }
        }

        while(!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);

    }
}
