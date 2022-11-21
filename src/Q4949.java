import java.util.Scanner;
import java.util.Stack;

public class Q4949 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 반복문을 종료할 조건
        boolean flag= true;
        // 문자열의 개수가 T개면 O(T)
        while(flag){
            // 한줄 씩 입력 받는다.
            String input = sc.nextLine();
            // 입력 받은 문자열이 .과 같다면 반복문을 종료
            if(input.equals(".")) {
                flag = false;
                break;
            }

            Stack<Integer> stack =new Stack<Integer>();
            // 문자열안에 괄호를 찾아 스택에 넣어준다. 문자열 전부 탐색해서 O(TN)
            for(int i = 0; i < input.length(); i++){
                int c= bracketToint(input.charAt(i));
                // stack의 top과 비교할 이전 값을 설정한다.
                int pre = -1;
                if(!stack.empty()) pre = stack.peek();
                if(c != -1) {
                    stack.push(c);
                    if((stack.peek() == 1 && pre == 0) || (stack.peek() == 3 && pre == 2)) {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
            if(stack.size() == 0) System.out.println("yes");
            else System.out.println("no");

        }
    }
    public static int bracketToint(char input){
        switch (input){
            case '(':
                return 0;
            case ')':
                return 1;
            case '[':
                return 2;
            case ']':
                return 3;
        }
        return -1;
    }
}
