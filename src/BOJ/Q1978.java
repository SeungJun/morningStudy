package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i <n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0;
        for (int i = 0; i < n  ; i++) {
            if(isPrime2(arr[i])) count++;
        }
        System.out.println(count);
    }

    public static boolean isPrime(int num){
        if(num == 1) return false;

        for (int i = 2 ; i < num; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    public static boolean isPrime2(int num){
        if(num == 1) return false;

        for (int i = 2 ; i <= Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
