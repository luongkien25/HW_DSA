package edu.HW_DSA.BT_Sort2;

public class PriorityQueue {
    private int[] arr;
    private int size;
    private int capacity;

    public PriorityQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public void insert(int x) {
        if (size == capacity) {
            System.out.println("Hàng đợi đã đầy");
            return;
        }
        arr[size] = x;
        size++;
        for (int i = size - 1; i > 0 && arr[i] < arr[i - 1]; i--) {
            int temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }
    }

    public int deleteMin() {
        if (size == 0) {
            System.out.println("Hàng đợi rỗng");
            return -1;
        }
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }
        size--;
        return min;
    }

    public void printQueue() {
        System.out.print("Hàng đợi: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);

        pq.insert(5);
        pq.insert(2);
        pq.insert(8);
        pq.insert(1);

        pq.printQueue();

        System.out.println("deleteMin = " + pq.deleteMin());
        pq.printQueue();

        pq.insert(3);
        pq.printQueue();
    }
}

