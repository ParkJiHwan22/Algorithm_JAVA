import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dx = {1, 0, -1, 0, 0, 0}; // 3차원 배열의 경우 좌표 생성
        int[] dy = {0, 1, 0, -1, 0, 0}; // 상하좌우앞뒤
        int[] dz = {0, 0, 0, 0, 1, -1};

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {break;} // L, R, C == 0

            boolean CanEscape = false;
            String time = null;
            Queue<Integer> queue = new LinkedList<>();
            String[][][] arr = new String[L][R][C];
            for (int i = 0; i < L; i++) { // 3차원 배열 입력
                for (int j = 0; j < R; j++) {
                    String line = br.readLine(); // 한 줄씩 읽어서
                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = line.substring(k, k+1);
                        if (arr[i][j][k].equals("S")) { // 시작지점을 찾으면
                            queue.add(i);
                            queue.add(j);
                            queue.add(k);
                        }
                    }
                }
                br.readLine(); // 층과 층 사이의 빈 줄을 읽어 넘김
            }

            while (!queue.isEmpty()) {
                int z = queue.poll();
                int y = queue.poll();
                int x = queue.poll();

                for (int dir = 0; dir < 6; dir++) {
                    if (z + dz[dir] >= 0 && z + dz[dir] < L && y + dy[dir] >= 0 && y + dy[dir] < R && x + dx[dir] >= 0 && x + dx[dir] < C) {
                        if (arr[z + dz[dir]][y + dy[dir]][x + dx[dir]].equals("E")) {
                            CanEscape = true;
                            time = arr[z][y][x];
                            break;
                        } else if (arr[z + dz[dir]][y + dy[dir]][x + dx[dir]].equals(".")) {
                            arr[z + dz[dir]][y + dy[dir]][x + dx[dir]] += arr[z][y][x];
                            queue.add(z + dz[dir]);
                            queue.add(y + dy[dir]);
                            queue.add(x + dx[dir]);
                        }
                    }
                }
            }
            if (CanEscape) {
                sb.append("Escaped in " + time.length() + " minute(s).").append("\n");
            } else sb.append("Trapped!").append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}
