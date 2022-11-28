import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q15683 {

    // 배열의 크기
    static int n;
    static int m;
    // 입력 받을 배열
    static int[][] arr;
    // 값을 채워나갈 배열
    static int[][] temp;
    static ArrayList<CCTV> cctv = new ArrayList<CCTV>();
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static class CCTV  {
        private int num;
        private int x;
        private int y;

        public CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        temp = new int[n][m];

        int min = 100;
        // 배열 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] != 6 && arr[i][j] != 0) {
                    cctv.add(new CCTV(arr[i][j], i, j));
                }
            }
        }

        // 방향이 4개이니깐 4진법을 이용
        for (int t = 0; t < (1 << (2 * cctv.size())); t++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            int brute = t;
            for (CCTV list : cctv) {
                int dir = brute % 4;
                brute /= 4;
                int num = list.num;
                int x = list.x;
                int y = list.y;

                switch (num) {
                    case 1:
                        fill(x, y, dir);
                        break;
                    case 2:
                        fill(x, y, dir);
                        fill(x, y, dir + 2);
                        break;
                    case 3:
                        fill(x, y, dir);
                        fill(x, y, dir + 1);
                        break;
                    case 4:
                        fill(x, y, dir);
                        fill(x, y, dir + 1);
                        fill(x, y, dir + 2);
                        break;
                    case 5:
                        fill(x, y, dir);
                        fill(x, y, dir + 1);
                        fill(x, y, dir + 2);
                        fill(x, y, dir + 3);
                        break;
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 0) count++;
                }
            }
            min = Math.min(min, count);
        }
        System.out.println(min);
    }

    // 해당 하는 방향의 값을 채워주는 함수
    static void fill(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            // 배열의 크기를 벗어나거나 벽을 마주치면 break;
            if (x < 0 || x >= n || y < 0 || y >= m) break;
            if(temp[x][y] == 6 )break;
            if (temp[x][y] != 0) continue;
            temp[x][y] =7;

        }

    }
}
