

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Queue{
    void push(int x);
    int pop();
    int size();
    int isEmpty();
    int front();
    int back();
}

class ArrayQueue implements Queue {
    private int front;
    private int rear;
    private int size;
    private int[] arr;

    public ArrayQueue(int size) {
        front = -1;
        rear = -1;
        this.size = size;
        arr = new int[this.size];
    }

    @Override
    public void push(int x) {
        arr[++rear] = x;
    }

    @Override
    public int pop() {
        if (isEmpty() == 1) return -1;
        return arr[++front];
    }

    @Override
    public int size() {
        if (isEmpty() == 1) return 0;
        else return rear - front;
    }

    @Override
    public int isEmpty() {
        if (front == rear) return 1;
        else return 0;
    }

    @Override
    public int front() {
        if (isEmpty() == 1) return -1;
        return arr[front+1];
    }

    @Override
    public int back() {

        if (isEmpty() == 1) return -1;

        return arr[rear];
    }

}
public class Q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test_case = Integer.parseInt(br.readLine());
        ArrayQueue queue = new ArrayQueue(10000);
        for (int i = 0; i < test_case; i++) {
            String input = br.readLine();
            String[] c = input.split(" ");
            switch (c[0]) {
                case "push":
                    queue.push(Integer.parseInt(c[1]));
                    break;
                case "pop":
                    System.out.println(queue.pop());
                    break;
                case "front":
                    System.out.println(queue.front());
                    break;
                case "back":
                    System.out.println(queue.back());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty());
                    break;

            }
        }
        br.close();
    }
}


