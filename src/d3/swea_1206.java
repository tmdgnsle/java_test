package d3;

import java.util.*;
import java.io.*;

public class swea_1206 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] A = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for(int i = 0; i< N-4; i++) {
				int start = i;
				int end = i + 4;
				int target = i + 2;
				int left = Math.max(A[start], A[start+1]);
				int right = Math.max(A[end], A[end-1]);
				if(A[target] < left || A[target] < right) {
					continue;
				} else {
					int max = Math.max(left, right);
					sum += A[target] - max;
				}
				
			}
			System.out.println("#" + t + " " + sum);
		}
	}
}
