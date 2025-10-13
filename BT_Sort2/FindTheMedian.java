package edu.HW_DSA.BT_Sort2;

import java.util.*;

public class FindTheMedian {

    public static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int mid = arr.length / 2;
        return arr[mid];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findMedian(arr));
    }
}