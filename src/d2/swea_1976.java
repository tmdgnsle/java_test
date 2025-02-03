package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int hour1 = Integer.parseInt(st.nextToken());
            int minute1 = Integer.parseInt(st.nextToken());
            int hour2 = Integer.parseInt(st.nextToken());
            int minute2 = Integer.parseInt(st.nextToken());

            int hour = hour1 + hour2;
            int minute = minute1 + minute2;

            if(minute >= 60){
                hour += 1;
                minute -= 60;
            }

            if(hour > 12){
                hour -= 12;
            }

            System.out.println("#" + t + " " + hour + " " + minute);
        }
    }
}
