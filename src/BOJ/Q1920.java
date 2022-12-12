import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1920 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        // 중복을 제거
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i <n ; i++) {
            set.add(sc.nextInt());
        }
        int m  = sc.nextInt();

        int[] arr =new int[m];
        for (int i = 0; i <m ; i++) {
            int temp = sc.nextInt();
            // 해당되는 정수가 포함되어 있는지 확인
            if(set.contains(temp)) arr[i] = 1;
            else arr[i] = 0;
        }
        for (int i = 0; i <m ; i++) {
            System.out.println(arr[i]);
        }
    }
}
