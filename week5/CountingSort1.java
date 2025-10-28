package edu.HW_DSA.week5;

import java.util.Scanner;

public class CountingSort1 {

    public static int[] countingSort(int[] arr) {
        int[] frequencyArray = new int[100];

        for (int i = 0; i < arr.length; i++) {
            frequencyArray[arr[i]]++;
        }

        return frequencyArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
