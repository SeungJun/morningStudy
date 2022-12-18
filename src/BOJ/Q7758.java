package BOJ;

import java.io.*;
import java.util.*;

public class Q7758 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출입 기록수 입력
        int n = Integer.parseInt(bufferedReader.readLine());

        // 출입 기록 입력 이름 enter/leave
        // TreeMap을 이용
        // key : 이름, value : 상태
        // 이름으로 검색했을때 value가 leave면 나간다

        TreeMap<String, String> data = new TreeMap<String, String>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            data.put(name, state);
        }


        // 키 값으로 내림차순 정렬
        for(Map.Entry<String, String> e : data.entrySet()) {
            if(e.getValue().equals("enter")) {
                bw.write(e.getKey() + "\n");
            }
        }
        bw.flush();
    }
}
