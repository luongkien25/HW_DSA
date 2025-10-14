package edu.HW_DSA.BT_PriorityQueue;

import java.io.*;
import java.util.*;

public class JesseAndCookies {

    static int cookies(int k, int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : A) pq.offer(x);

        int ops = 0;

        while (!pq.isEmpty() && pq.peek() < k) {
            if (pq.size() < 2) return -1;
            int least = pq.poll();
            int second = pq.poll();
            long mixed = (long) least + 2L * second;
            if (mixed > Integer.MAX_VALUE) {
                pq.offer(Integer.MAX_VALUE);
            } else {
                pq.offer((int) mixed);
            }
            ops++;
        }

        return ops;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nK = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(nK[0]);
        int k = Integer.parseInt(nK[1]);

        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        System.out.println(cookies(k, A));
    }
}

