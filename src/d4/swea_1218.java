package d4;

import java.util.*;
import java.io.*;

public class swea_1218 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_1218.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			int result = 1;
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);
				if (c == '(' || c == '{' || c == '[' || c == '<') {
					stack.add(c);
				}
				if (c == ')') {
					if (stack.peek() == '(')
						stack.pop();
					else {
						result = 1;
						break;
					}
				}
				if (c == '}') {
					if (stack.peek() == '{')
						stack.pop();
					else {
						result = 1;
						break;
					}
				}
				if (c == ']') {
					if (stack.peek() == '[')
						stack.pop();
					else {
						result = 1;
						break;
					}
				}
				if (c == '>') {
					if (stack.peek() == '<')
						stack.pop();
					else {
						result = 1;
						break;
					}
				}
			}

			if (!stack.isEmpty())
				result = 0;
			System.out.println("#" + t + " " + result);
		}
	}
}
