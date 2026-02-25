package 이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_2110 {


    static int N, C;
    static int[] x;

    static boolean canInstall(int dist) {
        int count = 1;          // 첫 집에 설치
        int last = x[0];

        for (int i = 1; i < N; i++) {
            if (x[i] - last >= dist) {
                count++;
                last = x[i];
                if (count >= C) return true; // 더 볼 필요 없음
            }
        }
        return count >= C;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        x = new int[N];
        for (int i = 0; i < N; i++) x[i] = Integer.parseInt(br.readLine());

        Arrays.sort(x);

        int low = 1;
        int high = x[N - 1] - x[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2; // 최소 거리 후보
            if (canInstall(mid)) {
                ans = mid;
                low = mid + 1;   // 더 큰 거리도 가능한지
            } else {
                high = mid - 1;  // 거리를 줄여야 함
            }
        }

        System.out.println(ans);
    }
}
