package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Q1926 {

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = -1;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && arr[i][j] == 1) {
                    result = solve(arr, i, j);
                    count ++;
                }
                max = Math.max(max, result);
            }
        }
        System.out.println(count);
        System.out.println(max);
    }
    // bfs를 하여 그림의 크기를 반환한다.
    public static int solve(int[][] arr, int row, int col) {
        // 하, 상, 좌, 우 이동할 방향
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // BFS를 사용하기 위한
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int count = 1;
        // 큐가 비었다면 종료
        while (!queue.isEmpty()) {
            // 큐에서 맨 앞에 값 poll
            int[] cur = queue.poll();
            // 방문했다면 0으로 처리

            for (int[] dir : dirs) {
                int next_row = cur[0] + dir[0];
                int next_col = cur[1] + dir[1];
                // 배열의 크기를 넘지 않고 방문하지 않았으며 값이 1이면 큐에 넣어준다.
                if (next_row >= 0 && next_row < arr.length && next_col >= 0 && next_col < arr[0].length) {
                    if (arr[next_row][next_col] == 1 && visited[next_row][next_col] == false) {
                        visited[next_row][next_col] = true;
                        // 다음 좌표를 큐에 넣어준다.
                        queue.offer(new int[]{next_row, next_col});
                        // 큐에 넣었다면 count 증가
                        count++;
                    }
                }
            }

        }

        return count;

    }
}
