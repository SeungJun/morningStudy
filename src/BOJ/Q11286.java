package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Q11286 {

    public static class absHeap implements Comparable<absHeap> {

        private int content;

        public absHeap(int content) {
            this.content = content;
        }

        public int getContent() {
            return content;
        }

        @Override
        public int compareTo(absHeap o) {
            // 절대값이 같다면 바꾼다.
            if (Math.abs(this.content) == Math.abs(o.getContent())) return this.content > o.getContent() ? 1 : -1;
            // 절대값이 작을때 변경
            return Math.abs(this.content) - Math.abs(o.getContent());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<absHeap> pq = new PriorityQueue<absHeap>();
        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == 0) {
                if (pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll().content);
            }
            else pq.add(new absHeap(cmd));
        }

    }
}
