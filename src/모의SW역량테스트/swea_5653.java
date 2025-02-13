package 모의SW역량테스트;

import java.io.*;
import java.util.*;

//Solution_d9_5653_줄기세포배양_구미_4반_이승훈

// dfs는 상으로 쭉, 하로갈때는 시간이 한참 지났을 때
// bfs는 동시에, 최소, 최단 경로 이럴때는 bfs이다
// bfs할때는 무조건 ArrayDeque
class swea_5653 {
    static final int[] di = {-1, 1, 0, 0}; // 상하좌우
    static final int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("res/input_d9_5653.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int R = K + N + K;
            int C = K + M + K;
            boolean[][] v = new boolean[R][C];
            //0i,1j,L, L+L
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> -Integer.compare(o1[2], o2[2])); // 최소 힙
//            PriorityQueue<int[]> qp = new PriorityQueue<>((o1, o2) -> o1[2].compareTo(o2[2])); // String일 경우
            for(int i = K; i < K + N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = K; j < K+M; j++) {
                    int L = Integer.parseInt(st.nextToken());
                    if(L!=0){
                        pq.offer(new int[]{i, j, L, L+L});
                    }
                }
            }
            for (int k = 0; k < K; k++) {

            }


            sb.append("#").append(tc).append(" ").append("size").append("\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}
