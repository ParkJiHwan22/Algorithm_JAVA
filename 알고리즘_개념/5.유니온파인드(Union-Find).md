# 유니온 파인드(Union-Find)

- 그래프 알고리즘, 두 노드가 같은 그래프에 속하는지 판별하는 알고리즘
- 서로소 집합, 상호 배타적 집합으로도 불림
- 노드를 합치는 Union 연산과 루트 노드를 찾는 Find 연산으로 이루어짐
- 최소신장트리 알고리즘에 이용됨

### Find 부분

``` java
int[] parent = [0, 1, 2, 3, 4, 5]; // 초기 설정

public static int Find(int x);
    if (x == parent[x]) return x; // 부모가 같을 경우 x를 출력
    return parent[x] = find(parent[x]); // 부모가 다를 경우 부모를 찾고 갱신한 다음 출력
```

### Union 부분

``` java
public static void Union(int x, int y);
    x = find(parent[x]);
    y = find(parent[y]);
    if (x != y) return parent[y] = x; // y의 부모를 새로 설정함, 합치는 부분