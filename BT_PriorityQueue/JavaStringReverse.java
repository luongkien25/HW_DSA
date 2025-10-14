package edu.HW_DSA.BT_PriorityQueue;

import java.util.*;

public class JavaStringReverse {
    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.hasNextLine() ? sc.nextLine().trim() : "";
        System.out.println(isPalindrome(s) ? "Yes" : "No");
        sc.close();
    }
}
