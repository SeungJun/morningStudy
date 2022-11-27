package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q15649 {

    static int n,m;
    static int[] arr = new int[8];
    static boolean[] check = new boolean[8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            arr[i] = i+1;
        }
        solve(0);

    }
    public static void solve(int index){
        if(index == m) {
            for (int i = 0; i < m ; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < n; i++) {
            if (!check[i]) {
                arr[index] = i + 1;
                check[i] = true;
                solve(index + 1);
                check[i] = false;
            }
        }
    }
}
