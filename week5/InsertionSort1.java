package edu.HW_DSA.week5;

import java.util.Scanner;

public class InsertionSort1 {

    public static void insertionSort1(int n, int[] arr) {
        int key = arr[n - 1];
        int i = n - 2;

        while (i >= 0 && arr[i] > key) {
            arr[i + 1] = arr[i];
            i--;
            printArray(arr);
        }

        arr[i + 1] = key;
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}

