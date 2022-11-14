package BOJ;

import java.util.Scanner;

public class BOJ10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = new String();

        input = sc.next();

        int[] check = new int[26];

        for(int i = 0; i < input.length(); i ++){
            check[input.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++){
            System.out.print(check[i]+" ");
        }
    }
}
