package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1431 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        List<Item> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new Item(sc.next()));
        }

        Collections.sort(list);

        for (Item item : list) {
            System.out.println(item.text);
        }

    }

    static class Item implements Comparable<Item> {
        int size;
        String text;
        int number;

        // 객체 생성자
        public Item(String text) {
            this.text = text;
            this.size = text.length();
            this.number = findNumber(text);
        }

        // 문자열에 있는 숫자 더하기
        private int findNumber(String str) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    sum += str.charAt(i) - '0';
                }
            }
            return sum;
        }
        // compareTo를 이용하여 객체 비교
        @Override
        public int compareTo(Item o) {
            // 사이즈 비교
            return this.size > o.size ? 1 : this.size < o.size ? -1 :
                    // 안에 있는 숫자비교
                    this.number > o.number ? 1 : this.number < o.number ? -1 :
                            //
                            this.text.compareTo(o.text);
        }
    }
}