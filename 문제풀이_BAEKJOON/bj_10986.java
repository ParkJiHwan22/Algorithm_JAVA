import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arrInt = new long[n+1]; // 1차원 배열
        long[] prefix = new long[n+1]; // 누적합 1차원 배열
        long[] remain = new long[m]; // 나머지 저장
        long cnt = 0; // 결과값

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) { // 1차원 배열에 입력 받기
            arrInt[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i < n+1; i++) { // 누적합 구하기
            prefix[i] = prefix[i-1] + arrInt[i];
        }

        for (int i = 1; i < n+1; i++) { // 누적합의 경우 counting
            if (prefix[i] % m == 0) {
                cnt += 1;
            }

            remain[(int) (prefix[i] % m)] += 1; // prefix에 나머지값을 저장
        }

        for (long i : remain) {
            if (i > 1) {
                cnt += (i * (i-1))/2;
            }
        }

        System.out.println(cnt);
    }
}