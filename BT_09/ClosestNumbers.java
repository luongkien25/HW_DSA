package edu.HW_DSA.BT_09;

import java.util.*;

public class ClosestNumbers {
    public static void mergeSort(int[] a) {
        if (a == null || a.length < 2) return;
        int n = a.length;
        int[] temp = new int[n];
        mergeSortRec(a, 0, n - 1, temp);
    }

    private static void mergeSortRec(int[] a, int l, int r, int[] temp) {
        if (l >= r) return;
        int m = l + (r - l) / 2;
        mergeSortRec(a, l, m, temp);
        mergeSortRec(a, m + 1, r, temp);
        merge(a, l, m, r, temp);
    }

    private static void merge(int[] a, int l, int m, int r, int[] temp) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (int t = l; t <= r; t++) a[t] = temp[t];
    }

    public static List<Integer> closestNumbers(int[] arr) {
        mergeSort(arr);

        long minDiff = Long.MAX_VALUE;
        for (int i = 0; i + 1 < arr.length; i++) {
            long diff = (long) arr[i + 1] - (long) arr[i];
            if (diff < minDiff) minDiff = diff;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i + 1 < arr.length; i++) {
            long diff = (long) arr[i + 1] - (long) arr[i];
            if (diff == minDiff) {
                result.add(arr[i]);
                result.add(arr[i + 1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sc.close();

        List<Integer> ans = closestNumbers(arr);
        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(' ');
        System.out.print(sb.toString().trim());
    }
}

