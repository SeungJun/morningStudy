package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Q2230 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 정렬
        Arrays.sort(arr);

        int size = n;
        int min = MAX_VALUE;
        int end = 0;
        for (int start = 0; start < n; start++) {
            while (end < n && arr[end] - arr[start] < m) end++;
            if (end == n) break;
            min = Math.min(min, arr[end] - arr[start]);
        }
        System.out.println(min);
    }
}
