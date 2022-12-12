import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1920_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new HashSet<Integer>();

        for(int i=0; i<n; i++) {
            set.add(Integer.parseInt(stk.nextToken()));
        }

        int t = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine(), " ");
        StringBuffer sb = new StringBuffer();

        while(t-->0) {
            int target = Integer.parseInt(stk.nextToken());
            if(set.contains(target)) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
