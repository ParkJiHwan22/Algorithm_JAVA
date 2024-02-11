package Boj_1647;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent; // 유니온-파인드 자료구조를 위한 부모 노드 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];
        parent = new int[N+1]; // 정점 번호가 1부터 시작한다고 가정

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            edges[i][0] = Integer.parseInt(st.nextToken());
            edges[i][1] = Integer.parseInt(st.nextToken());
            edges[i][2] = Integer.parseInt(st.nextToken());
        }
        // 가중치를 기준으로 간선 오름차순 정렬
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);

        // 유니온-파인드 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        int res = 0, lastCost = 0;
        for (int[] edge : edges) {
            if (find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                res += edge[2];
                lastCost = edge[2]; // 마지막에 추가된 간선의 비용을 저장
            }
        }

        System.out.print(res - lastCost);
    }
    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]); // 경로 압축
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x; // x를 y의 부모로 설정
        }
    }