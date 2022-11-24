package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()), B = Long.parseLong(st.nextToken()), C = Long.parseLong(st.nextToken());
        System.out.println(recur(A,B,C));

    }
    public static long recur(long A, long B, long C) {
        // 종료 조건
        if(B == 1) return A % C;
        // a^b =  a^(b/2) * a^(b/2) 인것을 이용
        long result = recur(A,B/2, C);
        result = result*result%C;
        // 짝수라면 값을 반환
        if(B%2 == 0) return result;
        // 홀수라면 A를 한번더 곱해서 반환
        return result * A % C;
    }


}
