import java.io.*; // 입출력 관련 클래스 import
import java.util.*; // 유틸리티 클래스 import

public class Main {

    public static void main(String[] args) throws Exception{
        
        // // BufferedReader와 InputStreamReader는 입력을 효율적으로 읽기 위해 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null; // StringTokenizer는 입력을 토큰(단어)으로 분리
        StringBuffer sb = new StringBuffer(); // StringBuffer는 결과를 누적하기 위해 사용

        int T = Integer.parseInt(br.readLine()); // 첫 번째 줄 읽음

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine()); // 한 줄의 입력을 읽고 토큰으로 분리
            int A = Integer.parseInt(st.nextToken()); // 첫 번째 토큰은 첫 번째 숫자
            int B = Integer.parseInt(st.nextToken()); // 두 번째 토큰은 두 번째 숫자
            sb.append(A + B).append('\n'); // A와 B의 합을 StringBuffer에 추가한 다음 줄바꿈
        }
        System.out.println(sb); // 모든 결과를 한 번에 출력

    }

}