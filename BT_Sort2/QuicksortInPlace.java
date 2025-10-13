package edu.HW_DSA.BT_Sort2;

import java.util.*;

public class QuicksortInPlace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.hasNextInt() ? sc.nextInt() : 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        quickSort(arr, 0, n - 1);
        sc.close();
    }

    static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int p = partitionLomuto(a, l, r);
        printArray(a);
        quickSort(a, l, p - 1);
        quickSort(a, p + 1, r);
    }

    static int partitionLomuto(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, i, r);
        return i;
    }

    static void swap(int[] a, int i, int j) {
        if (i == j) return;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    static void printArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(' ');
            sb.append(a[i]);
        }
        System.out.println(sb.toString());
    }
}
