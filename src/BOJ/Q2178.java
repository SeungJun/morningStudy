package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {

    public static int n, m;
    public static int[][] arr;

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, 1, 0, -1};

    public static class Node{
        private int x;
        private int y;
        private int detph;

        public Node(int x, int y, int detph) {
            this.x = x;
            this.y = y;
            this.detph = detph;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                // 문자열 입력
                arr[i][j] = s.charAt(j)-'0';
            }
        }
        // 문제에서 0,0 부터 시작하고 0,0 값은 항상 1
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {

        Queue<Node> queue = new LinkedList<Node>();
        // x, y , count를 통해 몇개의 칸을 지난지 확인한다.
        queue.offer(new Node(x,y,1));
        arr[x][y] = 0;
        int result = 0;
        // queue가 빌 때 까지 반복
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int curx  =temp.x;
            int cury  =temp.y;
            int count = temp.detph;
            // 도착 지점에 도착했다면
            if(curx == n-1 && cury == m-1) {
                return count;
            }


            // 4가지 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int next_x = curx + dx[i];
                int next_y = cury + dy[i];

                // 배열의 크기를 벗어나지 않고 값이 1이라면
                if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < m && arr[next_x][next_y] == 1) {
                    // queue에 넣어주고 count의 개수를 세준다.
                    queue.offer(new Node(next_x, next_y,count+1));
                    // 방문했으면 다시 0으로
                    arr[next_x][next_y] = 0;
                }
            }
        }
        return 0;
    }
}
