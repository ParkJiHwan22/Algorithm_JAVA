package Boj_16234;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] land = new int[N][N];
        Boolean endPoint = false;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (!endPoint) {
            int[][] visited = new int[N][N]; // 몇 번 국가와 같은지 + 방문 여부
            int[][] tmp = new int[N][N]; // 연합 국가의 총 인구수
            int[][] counting = new int[N][N]; // 연합 국가의 수

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        Queue<Integer> queue = new LinkedList<>();
                        visited[i][j] = i * N + j + 1; // 몇 번 국가와 같은지 체크
                        tmp[i][j] = land[i][j]; // 연합 국가의 총 인구수 세기 위함
                        counting[i][j]++; // 연합 국가의 수 세기 위함
                        queue.add(i);
                        queue.add(j);

                        while (!queue.isEmpty()) {
                            int y = queue.poll();
                            int x = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int ny = y + dy[dir];
                                int nx = x + dx[dir];

                                if (ny >= 0 && ny < N && nx >= 0 && nx < N && Math.abs(land[ny][nx] - land[y][x]) >= L && Math.abs(land[ny][nx] - land[y][x]) <= R && visited[ny][nx] != i * N + j + 1) {
                                    visited[ny][nx] = i * N + j + 1; // 방문여부 및 몇 번 국가와 연합인지 체크
                                    tmp[i][j] += land[ny][nx];
                                    counting[i][j]++;
                                    queue.add(ny);
                                    queue.add(nx);
                                }
                            }
                        }
                    }
                }
            }

            endPoint = true; // 값이 한번도 변하지 않으면 end처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (counting[i][j] != 0) { // 연합 국가의 수가 있을 떄
                        tmp[i][j] /= counting[i][j]; // 연합 국가의 총 인구 / 연합 국가의 수
                        if (land[i][j] != tmp[i][j]) {
                            endPoint = false;
                            land[i][j] = tmp[i][j];
                        }
                    } else if (visited[i][j] == visited[(visited[i][j] - 1) / N][(visited[i][j] - 1) % N]) { // 연합 국가인 경우 -> 코드로 생각해내기 어려운 부분
                        if (land[i][j] != tmp[(visited[i][j] - 1) / N][(visited[i][j] - 1) % N]) {
                            endPoint = false;
                            land[i][j] = tmp[(visited[i][j] - 1) / N][(visited[i][j] - 1) % N];
                        }
                    }
                }
            }
            cnt++;
        }
        System.out.println(cnt - 1);
    }
}