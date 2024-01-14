import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0; // 막대의 총 길이
        int k = 64; // 자른 막대의 길이
        int cnt = 0; // 막대의 개수

        while (res != n) { // 원하는 길이와 자른 막대의 총 길이의 합이 같으면 종료
            if (k + res <= n) {
                res += k;
                cnt += 1;
            }
            k /= 2;
        }

        System.out.println(cnt);
    }
}