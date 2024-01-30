import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        // 각 노드의 부모 노드를 저장하는 배열
        int[] parent = new int[n+1];

        // 연결리스트 배열
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        // 방문 체크 배열
        boolean[] visited = new boolean[n+1];
        StringTokenizer st;
        for (int i = 1; i < n; i++) {
             st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : adj[cur]) {
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                queue.add(next);
                parent[next] = cur;
            }
        }

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);
    }
}
