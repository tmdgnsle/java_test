package swea;

import java.io.*;
import java.util.*;

public class swea_2112 {
    static int D, W, K;  // D: 필름 두께, W: 가로 크기, K: 합격 기준
    static int min;      // 최소 약품 투입 횟수
    static int inject[]; // 각 행에 투입할 약품 정보 (-1: 그대로, 0: A, 1: B)
    static int map[][];  // 필름 정보를 저장하는 배열

    static boolean check() {
        outer:
        for (int w = 0; w < W; w++) {         // 1️⃣ 각 세로줄마다 검사
            int cnt = 1;                       // 2️⃣ 연속된 같은 특성의 개수
            for (int d = 0; d < D - 1; d++) { // 3️⃣ 위에서부터 아래로 검사
                // 4️⃣ 현재 위치의 특성 확인
                int curr = inject[d] == -1 ? map[d][w] : inject[d];
                // 5️⃣ 다음 위치의 특성 확인
                int next = inject[d + 1] == -1 ? map[d + 1][w] : inject[d + 1];

                if (curr == next) {           // 6️⃣ 같은 특성이 연속되면
                    cnt++;                     // 카운트 증가
                    if (cnt >= K) continue outer; // 7️⃣ K개 이상이면 다음 세로줄로
                } else {                      // 8️⃣ 다른 특성이 나오면
                    cnt = 1;                   // 카운트 다시 1부터
                }
            }
            if (cnt < K) return false;        // 9️⃣ 이 세로줄은 조건 미달!
        }
        return true;                          // 🔟 모든 세로줄이 조건 만족!
    }

    static void subs(int cnt, int su) {
        // cnt: 현재 확인중인 행
        // su: 지금까지 약품을 투입한 횟수

        // 이미 찾은 최소값보다 많이 썼다면 그만둬요
        if (su >= min) return;

        // 모든 행을 다 확인했다면
        if (cnt == D) {
            if (check()) min = Math.min(min, su);
            return;
        }

        // 세 가지 경우를 시도해봐요
        inject[cnt] = -1;  // 1. 약품을 넣지 않기
        subs(cnt + 1, su);

        inject[cnt] = 0;   // 2. A 약품 넣기
        subs(cnt + 1, su + 1);

        inject[cnt] = 1;   // 3. B 약품 넣기
        subs(cnt + 1, su + 1);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d9_2112.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[D][W];
            inject = new int[D];
            for (int d = 0; d < D; d++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int w = 0; w < W; w++) {
                    map[d][w] = Integer.parseInt(st.nextToken());
                }
            }
            min = K; // 최악의 경우 K번까지 갈 일이 없다
            subs(0, 0);//cnt행,su주입수
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}