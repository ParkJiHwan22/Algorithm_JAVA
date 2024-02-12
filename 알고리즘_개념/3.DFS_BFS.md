``` java
import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visited; // 방문 여부
    static boolean[][] arr; // 간선 그래프
    static List<Integer> ans_dfs; // DFS 방문 순서를 저장할 리스트
    static List<Integer> ans_bfs; // BFS 방문 순서를 저장할 리스트

    static Queue<Integer> queue; // queue 구현

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1]; // 방문 여부
        arr = new boolean[n + 1][n + 1]; // 간선 그래프
        ans_dfs = new ArrayList<>(n); // DFS 정답을 넣는 List

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt((st.nextToken()));

            arr[start][end] = true;
            arr[end][start] = true;
        }

        ans_bfs = new ArrayList<>(n); // BFS 정답을 넣는 List
        queue = new LinkedList<>();
        bfs(v);

        visited = new boolean[n + 1]; // 방문 여부 갱신
        dfs(v);

        for (int node : ans_dfs) {
            System.out.print(node + " ");
        }
        System.out.println();

        for (int node : ans_bfs) {
            System.out.print(node + " ");
        }
    }
    public static void dfs(int num) {
        visited[num] = true;
        ans_dfs.add(num);

        for (int i = 1; i < arr[num].length; i++) {
            if (arr[num][i] && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int num) {
        queue.add(num);
        visited[num] = true;
        while (!queue.isEmpty()) {
            int q = queue.poll();
            ans_bfs.add(q);

            for (int i = 1; i < arr[q].length; i++) {
                if (arr[q][i] && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

}
```