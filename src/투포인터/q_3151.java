package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_3151 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬 - 투 포인터를 사용하기 위함
        Arrays.sort(arr);

        long answer = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    if (arr[left] == arr[right]) {
                        int count = right - left + 1;
                        answer += (long) count * (count - 1) / 2;
                        break;
                    } else {
                        int leftCount = 1;
                        int rightCount = 1;
                        while (left + leftCount < right && arr[left] == arr[left + leftCount]) {
                            leftCount++;
                        }
                        while (right - rightCount > left && arr[right] == arr[right - rightCount]) {
                            right--;
                            rightCount++;
                        }

                        answer += (long) leftCount * rightCount;
                        left += leftCount;
                        right += rightCount;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}
