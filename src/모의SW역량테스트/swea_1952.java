package 모의SW역량테스트;

import java.util.*;
import java.io.*;

public class swea_1952 {
	static int[] plan;
	static int[] price;
	static int min;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/input_1952.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			price = new int[4];
			plan = new int[13];
			min = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
				min += price[0]*plan[i];
			}
			
			
			
		}
	}
}
