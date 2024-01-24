package variable.operator;

import java.io.*;
import java.util.*;

public class Main {

    static int num;
    static int[] arrInt = {0, 1, 2, 3, 4, 5, 6, 7, 8};
    static boolean[] vis = new boolean[arrInt.length]; // 방문
    static int[] tmp;
    static int maxScore = 0; // 최대 점수를 저장할 변수
    static int n; // 게임 수
    static int[][] players; // 선수 정보
    static int[] battingOrder = new int[9]; // 타순

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        players = new int[n][9];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                players[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = arrInt.length;
        tmp = new int[num];
        backtracking(0);
        System.out.println(maxScore);
    }

    private static void backtracking(int depth) {
        if (depth == num) {
            if (battingOrder[3] == 0) {
                if (num >= 0) System.arraycopy(tmp, 0, battingOrder, 0, num);
                calculateScore();
            }
            return;
        }

        for (int i = 0; i < num; i++) {
            if (!vis[i]) {
                vis[i] = true;
                battingOrder[depth] = arrInt[i]; // tmp에 arrInt의 값을 집어넣음
                backtracking(depth + 1); // 넣으면 다음 칸으로
                vis[i] = false;
            }
        }
    }

    static void calculateScore() {
        int score = 0;
        int battingCount = 0; // 숫자를 계속 키운 다음 (% 9)

        for (int i = 0; i < n; i++) {
            int outCount = 0; // 아웃카운트
            boolean[] runner = new boolean[3];

            while (outCount != 3) {
                int res = players[i][battingOrder[battingCount % 9]];
                if (res == 0) { // 0 = 아웃
                    outCount ++;
                } else { // 1 = 안타, 2 = 2루타, 3 = 3루타, 4 = 홈런
                    for (int j = 2; j >= 0; j--) { // 주자가 있을 경우,
                        if (runner[j]) { // 주자가 있을 때
                            if (res - 1 + j >= 3) { // 주자가 득점
                                runner[j] = false;
                                score ++;
                            } else { // 주자가 진루
                                runner[res - 1 + j] = true;
                                runner[j] = false;
                            }
                        }
                    }

                    if (res != 4) { // 홈런이 아니면
                        runner[res-1] = true; // 타자 주자 진루
                    } else { // 홈런이면
                        score ++; // 주자도 홈인
                    }
                }
                battingCount ++;
            }
        }
        if (maxScore < score) {
            maxScore = score;
        }
    }
}