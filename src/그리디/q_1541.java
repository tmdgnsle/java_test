package 그리디;

import java.io.*;
import java.util.*;

public class q_1541 {
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String example = sc.nextLine();
        String[] str = example.split("-");
        for (int i = 0; i < str.length; i++) {
            int temp = mySum(str[i]);
            if (i == 0) answer = answer + temp;
            else answer = answer - temp;
        }
        System.out.println(answer);
    }

    static int mySum(String a) {
        int sum = 0;
        String[] temp = a.split("[+]");
        for (int i = 0; i < temp.length; i++) {
            sum = sum + Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
