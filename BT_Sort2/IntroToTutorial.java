package edu.HW_DSA.BT_Sort2;

import java.util.*;

public class IntroToTutorial {
    static int introTutorial(int V, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == V) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = introTutorial(V, arr);
        System.out.println(result);
    }
}

