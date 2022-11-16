package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Stack{
    int isEmpty();
    int getSize();
    void push(int item);
    int pop();
    int peek();
    void clear();
}
class ArrayStack implements Stack {
    private int top;
    private int size;
    private int[] arr;

    public ArrayStack(int size) {
        top = -1;
        this.size = size;
        arr = new int[this.size];
    }

    // 스택 top에 값을 삽입
    public void push(int n){
        arr[++top] = n;
    }
    // 스택 top의 값을 제거 하고 그값을 출력
    // 스택이 비어 있다면 -1을 출력
    public int pop(){
        if(top == -1) return -1;
        else {
            return arr[top--];
        }
    }

    public int getSize(){
        return top+1;
    }
    public int isEmpty() {
        if(top == -1) return 1;
        else return 0;
    }
    public int peek(){
        if(top == -1) return -1;
        return arr[top];
    }

    @Override
    public void clear() {
        arr = new int[this.size];
        top = -1;
    }
}
public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test_case = Integer.parseInt(br.readLine());
        ArrayStack stack = new ArrayStack(10000);
        for (int i = 0; i < test_case; i++) {
            String input = br.readLine();
            String[] c = input.split(" ");
            switch (c[0]) {
                case "push":
                    stack.push(Integer.parseInt(c[1]));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "top":
                    System.out.println(stack.peek());
                    break;
                case "size":
                    System.out.println(stack.getSize());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty());
                    break;

            }
        }
        br.close();
    }

}


