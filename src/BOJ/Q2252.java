package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> grape = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= n; i++) {
            grape.add(new ArrayList<>());
        }

        int[] indegree = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            String[] temp = br.readLine().split(" ");
            int n1 = Integer.parseInt(temp[0]);
            int n2 = Integer.parseInt(temp[1]);

            // 첫번째 값에서 두번째 값으로 단방향으로 그래프 연결
            grape.get(n1).add(n2);
            indegree[n2]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            // indegree가 0인 값을 queue에 넣어준다.
            if (indegree[i] == 0) queue.offer(i);
        }

        // queue가 빌때 까지 진행
        while (!queue.isEmpty()) {
            // queue 값을 하나 뺀다
            int index = queue.poll();
            // 뺐다면 결과에 다시 넣어준다. 
            sb.append(index);
            sb.append(" ");
            for (Integer integer : grape.get(index)) {
                // indegree를 감소 시켜준다.
                indegree[integer]--;
                // indegree가 0이면 queue에 넣어준다.
                if (indegree[integer] == 0) queue.offer(integer);
            }
        }
        System.out.println(sb);
    }
}

