package variable.operator;

import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0; // 합계를 저장할 변수
        int N = Integer.parseInt(br.readLine()); // 정수 N 입력
        String nums = br.readLine(); // 문자열로 숫자들을 입력 받음

        for (int i = 0; i < N; i++) {
            total += nums.charAt(i) -'0';
        }

        System.out.print(total);
    }
}