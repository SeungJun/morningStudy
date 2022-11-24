package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Stack;

public class Q1926_2 {

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
        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == false && arr[i][j] == 1) {
                    temp = dfs(arr, i, j)+1;

                    result = Math.max(temp,result);
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(result);
    }

    // bfs를 하여 그림의 크기를 반환한다.
    public static int dfs(int[][] arr, int row, int col) {
        // 하, 상, 좌, 우 이동할 방향
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        visited[row][col] = true;
        int count = 0;
        for (int[] dir : dirs) {
            int next_row = row + dir[0], next_col = col + dir[1];
            if (next_row >= 0 && next_row < arr.length&& next_col >= 0 && next_col < arr[0].length) {
                if (arr[next_row][next_col] == 1 && visited[next_row][next_col] == false) {
                   count += dfs(arr, next_row,next_col)+1;
                }
            }
        }

        return count;

    }
}
