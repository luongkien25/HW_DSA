package edu.HW_DSA.week4;
import java.util.Stack;
import java.util.Scanner;

public class QueueUsingTwoStacks {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int x) {
        stack1.push(x);
    }

    public void dequeue() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public void printFront() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (!stack2.isEmpty()) {
            System.out.println(stack2.peek());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();

        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            if (queryType == 1) {
                int x = sc.nextInt();
                queue.enqueue(x);
            } else if (queryType == 2) {
                queue.dequeue();
            } else if (queryType == 3) {
                queue.printFront();
            }
        }
    }
}


