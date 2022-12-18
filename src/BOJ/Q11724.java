package BOJ;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11724 {
    // BFS 방문 여부 확인
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 그래프는 1부터 시작
        visited = new int[n + 1];

        graph = new ArrayList<ArrayList<Integer>>();
        // 인접 리스트로 구성한 그래프에 ArrayList를 넣어주면서 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] nv = br.readLine().split(" ");
            int n1 = Integer.parseInt(nv[0]);
            int n2 = Integer.parseInt(nv[1]);

            // 그래프 서로 연결
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i] == 0) {
                bfs(i);
                count++;
            }
        }
        System.out.print(count);
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
                    queue.add(result);
                }
            }
        }
    }
}
