package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1406 {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력을 위해 BR, BW 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String input = br.readLine();
        int numCom = Integer.parseInt(br.readLine());
        // Arraylist는 삽입, 삭제할때 크기를 늘리고 줄이는 연산을 하기 때문에 느리다.
        LinkedList<Character> list = new LinkedList<Character>();

        for (int i = 0; i < input.length(); i++) {
            list.add(input.charAt(i));
        }

        // 커서의 역할
        ListIterator<Character> iter = list.listIterator();
        while (iter.hasNext()){
            iter.next();
        }
        for(int i = 0; i < numCom; i++){
            String com = br.readLine();
            char c = com.charAt(0);
            switch (c){
                case 'L':
                    if(iter.hasPrevious()) iter.previous();
                    break;
                case 'D':
                    if(iter.hasNext()) iter.next();
                    break;
                case 'B':
                    if(iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                    break;
                case 'P':
                    char t = com.charAt(2);
                    iter.add(t);
                    break;
            }
        }
        for (Character s : list) {
            bw.write(s);
        }
        bw.flush();
        bw.close();
    }
}
