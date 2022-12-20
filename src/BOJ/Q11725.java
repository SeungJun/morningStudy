package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11725 {
    // BFS 방문 여부 확인
    static int[] visited;

    static int[] parent;
    static ArrayList<ArrayList<Integer>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        // 그래프는 1부터 시작
        visited = new int[n + 1];
        parent = new int[n+1];
        graph = new ArrayList<ArrayList<Integer>>();
        // 인접 리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);

            // 그래프 서로 연결
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }



        bfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start); // 0을 큐에 저장
        visited[start] = 1;

        while (!queue.isEmpty()) { // 큐에 아무것도 없을때까지 동작
            int cur = queue.poll(); // 큐에서 제일 먼저 넣은 정점을 꺼냄
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int result = graph.get(cur).get(i);
                if (visited[result] == 0) {
                    visited[result] = 1;
                    // 이전 큐에서 뺀 값이 부모 노드가 된다.
                    parent[result] = cur;
                    queue.add(result);
                }
            }
        }
    }
}
