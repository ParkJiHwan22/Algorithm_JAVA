import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] lab = new int[n][m];

        int[] dx = {1, 0, -1, 0}; // 델타 배열
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) { // lab의 입력값 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ns = n * m; // n * m 의 곱을 ns로 나타냄
        int safeArea = 0; // 안전 영역
        for (int i = 0; i < ns-2; i++) {
            if (lab[i / m][i % m] != 0) { continue;}
            for (int j = i + 1; j < ns-1; j++) {
                if (lab[j / m][j % m] != 0 ) { continue;}
                for (int k = j + 1; k < ns; k++) {
                    if (lab[k / m][k % m] == 0) { // 세 지점의 값이 전부 0일 때
                        int tmp = 0;
                        
                        int[][] labCopy = new int[n][m]; // 새 배열 생성, 앞으로 labCopy에 입력
                        for (int a = 0; a < n; a++) {   // lab은 보존하고 깊은 복사를 한 labCopy에 값 입력
                            for (int b = 0; b < m; b++) {
                                labCopy[a][b] = lab[a][b]; // 각 요소를 직접 복사
                            }
                        }
                        labCopy[i / m][i % m] = 1;
                        labCopy[j / m][j % m] = 1;
                        labCopy[k / m][k % m] = 1;

                        Queue<Integer> queue = new LinkedList<>(); // Queue 생성
                        for (int a = 0; a < n; a++) {
                            for (int b = 0; b < m; b++) {
                                if (labCopy[a][b] == 2) { // labCopy의 값이 2일 때
                                    queue.add(a);
                                    queue.add(b);
                                }
                            }
                        }

                        while (!queue.isEmpty()) { // BFS 계산
                            int y = queue.poll();
                            int x = queue.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                if (x + dx[dir] >= 0 && x + dx[dir] < m && y + dy[dir] >= 0 && y + dy[dir] < n && labCopy[y + dy[dir]][x + dx[dir]] == 0) {
                                    labCopy[y + dy[dir]][x + dx[dir]] = 2; // 안전영역을 삭제
                                    queue.add(y + dy[dir]);
                                    queue.add(x + dx[dir]);
                                }
                            }
                        }
                        for (int r = 0; r < n; r++) { // 안전영역의 개수 구함
                            for (int c = 0; c < m; c++) {
                                if (labCopy[r][c] == 0) {
                                    tmp ++;
                                }
                            }
                        }
                        if (safeArea < tmp) { // 안전영역의 최댓값
                            safeArea = tmp;
                        }

                    }
                }
            }
        }
        System.out.println(safeArea);
    }
}
