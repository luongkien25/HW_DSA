package edu.HW_DSA.BT_PriorityQueue;

import java.util.*;

class Node {
    Node[] child = new Node[26];
    boolean end;
    int count;
}

public class WordCount {
    private static Node root = new Node();

    static void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            if (!Character.isLetter(c)) continue;
            int idx = c - 'a';
            if (cur.child[idx] == null) {
                cur.child[idx] = new Node();
            }
            cur = cur.child[idx];
        }
        cur.end = true;
        cur.count++;
    }

    static void dfs(Node node, StringBuilder sb) {
        if (node.end) {
            System.out.println(sb.toString() + " " + node.count);
        }
        for (int i = 0; i < 26; i++) {
            if (node.child[i] != null) {
                sb.append((char) ('a' + i));
                dfs(node.child[i], sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập văn bản:");
        StringBuilder text = new StringBuilder();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.trim().isEmpty()) break;
            text.append(line).append(" ");
        }

        String[] words = text.toString().toLowerCase().split("[^a-z]+");
        for (String w : words) {
            if (!w.isEmpty()) insert(w);
        }

        System.out.println("\nKết quả đếm từ:");
        dfs(root, new StringBuilder());
        sc.close();
    }
}
