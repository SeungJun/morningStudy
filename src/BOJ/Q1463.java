package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // dp[0]은 사용하지 않느다.
        int[] dp = new int[1000002];
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            // 2와 3으로 나눠지지 않을때
            dp[i] = dp[i-1]+1;

            if(i%3 == 0) dp[i] = Math.min(dp[i/3]+1,dp[i]);
            if(i%2 == 0) dp[i] = Math.min(dp[i/2]+1,dp[i]);
        }

        System.out.println(dp[n]);
    }
}
