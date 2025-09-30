package edu.HW_DSA.week4;
import java.util.Scanner;
import java.util.Stack;

public class EqualStacks {

    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        for (int i = 0; i < h1.length; i++) sum1 += h1[i];
        for (int i = 0; i < h2.length; i++) sum2 += h2[i];
        for (int i = 0; i < h3.length; i++) sum3 += h3[i];

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();

        for (int i = 0; i < h1.length; i++) stack1.push(h1[i]);
        for (int i = 0; i < h2.length; i++) stack2.push(h2[i]);
        for (int i = 0; i < h3.length; i++) stack3.push(h3[i]);

        while (sum1 != sum2 || sum2 != sum3) {
            if (sum1 > sum2 || sum1 > sum3) {
                sum1 -= stack1.pop();
            }
            else if (sum2 > sum1 || sum2 > sum3) {
                sum2 -= stack2.pop();
            }
            else {
                sum3 -= stack3.pop();
            }
        }
        return sum1;
    }
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();
        int[] h1 = new int[n1];
        int[] h2 = new int[n2];
        int[] h3 = new int[n3];
        for (int i = 0; i < n1; i++) {
            h1[i] = scanner.nextInt();
        }
        for (int i = 0; i < n2; i++) {
            h2[i] = scanner.nextInt();
        }
        for (int i = 0; i < n3; i++) {
            h3[i] = scanner.nextInt();
        }
        reverseArray(h1);
        reverseArray(h2);
        reverseArray(h3);
        int result = equalStacks(h1, h2, h3);
        System.out.println(result);
    }
}

