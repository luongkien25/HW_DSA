package edu.HW_DSA.week4;
import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')) {
                    return "NO";
                }
            }
        }


        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
        }

        for (String t : a) {
            System.out.println(isBalanced(t));
        }
    }
}
