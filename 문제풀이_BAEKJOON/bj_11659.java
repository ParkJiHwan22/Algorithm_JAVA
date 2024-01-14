package variable.operator;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        // 첫 번째 줄에서 n과 m을 읽어옴
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 두 번째 줄에서 n개의 정수를 읽어옴
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 부분합을 저장하는 함수 생성
        int[] sNum = new int[n+1];
        sNum[0] = 0;
        for (int k = 1; k < n+1; k++) {
            sNum[k] = sNum[k-1] + array[k-1];
        }

        // m개의 줄에 걸쳐서 각 줄에서 두 개의 정수를 읽어옴
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(sNum[b] - sNum[a-1] + "\n");
        }

        System.out.print(sb.toString()); // 모든 출력을 한 번에 출력
    }
}