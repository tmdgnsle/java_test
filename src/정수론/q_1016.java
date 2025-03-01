package 정수론;

import java.io.*;
import java.util.*;

public class q_1016 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();

        boolean[] Check = new boolean[(int) (Max - Min + 1)];

        for (long i = 2; i * i <= Max; i++) {
            long pow = i * i;
            long start_index = Min / pow;
            if (Min % pow != 0) start_index++;
            for (long j = start_index; pow * j <= Max; j++) {
                Check[(int) ((j * pow) - Min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= Max - Min; i++) {
            if (!Check[i]) count++;
        }

        System.out.println(count);

    }
}
