import java.io.*;
import java.util.*;

public class Main {

    static int M, N;

    static int[][] arrInt;
    static int[][] dp;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arrInt = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arrInt[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0)); // 출발 지점
        System.out.println(Arrays.deepToString(dp));
    }

    public static int dfs(int y, int x) {
        if (y == M - 1 && x == N - 1) return 1;

        if (dp[y][x] == -1) {
            dp[y][x] = 0;
            for (int dir = 0; dir < 4; dir++) {
                int ny = y + dy[dir];
                int nx = x + dx[dir];

                if (ny < 0 || ny > M - 1 || nx < 0 || nx > N - 1) continue;

                if (arrInt[y][x] > arrInt[ny][nx]) {
                    dp[y][x] += dfs(ny, nx);
                }
            }
        }
        return dp[y][x];
    }
}