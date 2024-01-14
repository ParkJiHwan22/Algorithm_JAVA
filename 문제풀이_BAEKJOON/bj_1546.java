import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = 0; // 점수의 합계를 저장할 변수
        int scoreMax = 0; // 점수의 최댓값
        int N = Integer.parseInt(br.readLine()); // 점수의 개수 N 입력
        st = new StringTokenizer(br.readLine()); // 입력된 숫자들을 공백으로 구분

        // 입력된 숫자들에 대해 반복
        for (int i = 0; i < N; i++) {
            int score = Integer.parseInt(st.nextToken()); // 다음 토큰을 정수로 변환
            total += score;

            if (scoreMax < score) {
                scoreMax = score;
            }
        }

        System.out.println((double)total*100/(scoreMax * N)); // 결과 출력
    }
}