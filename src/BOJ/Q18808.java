package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Q18808 {

    // 노트북의 크기
    static int n, m;
    // 스티커의 개수
    static int k;
    static int[][] notebook = new int[42][42];


    // 스티커의 크기
    static int r, c;
    static int[][] paper = new int[12][12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 스티커의 개수만큼 반복문을 돈다
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 스티커 입력
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < c; l++) {
                    paper[j][l] = Integer.parseInt(st.nextToken());
                }
            }
            check:
            for (int j = 0; j < 4; j++) {
                for (int l = 0; l <= n - r; l++) {
                    // 붙였다면 다음 스티커
                    for (int o = 0; o <= m - c; o++) {
                        if (postable(l, o)) {
                            break check;
                        }
                    }
                }
                rotation();
            }
        }
        int cnt = 0;
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j<m; j++){
                cnt += notebook[i][j];
            }
        }
        System.out.println(cnt);
    }

    public static void rotation() {
        // 행열 크기 변환
        int[][] temp = new int[12][12];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = paper[i][j];
            }
        }
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                paper[i][j] = temp[r - 1 - j][i];
            }
        }
        // 좌표도 바꿔준다
        int t = r;
         r = c;
         c = t;
    }
    

    public static boolean postable(int x, int y) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (notebook[x + i][y + j] == 1 && paper[i][j] == 1)
                    return false;
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (paper[i][j] == 1)
                    notebook[x + i][y + j] = 1;
            }
        }
        return true;
    }
}
