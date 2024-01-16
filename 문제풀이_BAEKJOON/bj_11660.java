package variable.operator;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arrInt = new int[n+1][n+1]; // 2차원 배열
        int[][] prefix = new int[n+1][n+1]; // 누적합 2차원 배열
        int res = 0; // 결과값

        for (int i = 1; i < n+1; i++) { // 2차원 배열에 입력 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                arrInt[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n+1; i++) { // 누적합 구하기
            for (int j = 1; j < n+1; j++) {
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + arrInt[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            res = prefix[x2][y2] - prefix[x2][y1-1] - prefix[x1-1][y2] + prefix[x1-1][y1-1]; // 결과값
            sb.append(res);

            if (i < m-1) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}