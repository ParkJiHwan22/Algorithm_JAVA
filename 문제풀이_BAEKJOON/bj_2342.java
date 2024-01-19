import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[100000];
        int w = 0;
        int t;
        int cnt = 0; // 입력받은 스텝의 수

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            t = Integer.parseInt(st.nextToken());
            if (t == 0) break;
            arr[w++] = t;
            cnt++; // 스텝 수 증가
        }

        if (cnt == 0) {
            System.out.println(0);

        } else {
            // 한 발씩 체크해도 됨(양발 동시에 체크할 필요 x)
            // 발판의 위치는 0, 1, 2, 3, 4 중 하나임
            int[][][] dp = new int[cnt][5][5]; // 0, 1, 2, 3, 4

            dp[0][0][arr[0]] = 2; // 시작점이 중앙이므로, 에너지 사용 없음
            dp[0][arr[0]][0] = 2; // 시작점이 중앙이므로, 에너지 사용 없음

            for (int i = 1; i < cnt; i++) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k ++) {
                        if (dp[i-1][j][k] != 0) {
                            if (arr[i] != j && arr[i] != k) {  // 다음 스텝이 발 위에 없는 경우
                                if (Math.abs(j - arr[i]) == 2) { // 왼발과 반대쪽에 놓일 때
                                    if (j == 0) { // 0이 존재할 경우, 0에 있는 발 이동
                                        dp[i][arr[i]][k] = dp[i - 1][j][k] + 2;
                                    }
                                    if (k == 0) {
                                        dp[i][j][arr[i]] = dp[i - 1][j][k] + 2;
                                    }
                                    if (dp[i][arr[i]][k] > dp[i-1][j][k] + 4 || dp[i][arr[i]][k] == 0) {
                                        dp[i][arr[i]][k] = dp[i-1][j][k] + 4;
                                    }
                                    if (dp[i][j][arr[i]] > dp[i-1][j][k] + 3 || dp[i][j][arr[i]] == 0) {
                                        dp[i][j][arr[i]] = dp[i-1][j][k] + 3;
                                    }
                                } else if (Math.abs(k - arr[i]) == 2) { // 오른발과 반대쪽에 놓일 때
                                    if (j == 0) { // 0이 존재할 경우, 0에 있는 발 이동
                                        dp[i][arr[i]][k] = dp[i - 1][j][k] + 2;
                                    }
                                    if (k == 0) {
                                        dp[i][j][arr[i]] = dp[i - 1][j][k] + 2;
                                    }
                                    if (dp[i][j][arr[i]] > dp[i - 1][j][k] + 4 || dp[i][j][arr[i]] == 0) {
                                        dp[i][j][arr[i]] = dp[i - 1][j][k] + 4;
                                    }
                                    if (dp[i][arr[i]][k] > dp[i - 1][j][k] + 3 || dp[i][arr[i]][k] == 0) {
                                        dp[i][arr[i]][k] = dp[i - 1][j][k] + 3;
                                    }
                                } else { // 발이 대각선으로 놓여있을 때
                                    if (j == 0) { // 0이 존재할 경우, 0에 있는 발 이동
                                        dp[i][arr[i]][k] = dp[i - 1][j][k] + 2;
                                    }
                                    if (k == 0) {
                                        dp[i][j][arr[i]] = dp[i - 1][j][k] + 2;
                                    }
                                    if (dp[i][j][arr[i]] > dp[i - 1][j][k] + 3 || dp[i][j][arr[i]] == 0) {
                                        dp[i][j][arr[i]] = dp[i - 1][j][k] + 3;
                                    }
                                    if (dp[i][arr[i]][k] > dp[i - 1][j][k] + 3 || dp[i][arr[i]][k] == 0) {
                                        dp[i][arr[i]][k] = dp[i - 1][j][k] + 3;
                                    }
                                }
                            } else { // 다음 스텝이 발 위에 있는 경우
                                if (dp[i][j][k] > dp[i-1][j][k] + 1 || dp[i][j][k] == 0) {
                                    dp[i][j][k] = dp[i-1][j][k] + 1;
                                }
                            }
                        }
                    }
                }
            }

            int minEnergy = Integer.MAX_VALUE; // 최소 에너지 사용량
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (minEnergy > dp[cnt-1][i][j] && dp[cnt-1][i][j] != 0) {
                        minEnergy = dp[cnt-1][i][j];
                    }
                }
            }
            System.out.println(minEnergy); // 결과 출력
        }
    }
}