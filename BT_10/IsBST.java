package edu.HW_DSA.BT_10;

import java.util.*;

class Tree {
    Vector<Integer> values;
    private int count;

    Tree() {
        this.values = new Vector<Integer>();
        this.count = 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }

    public void inOrder(Node root, Vector<Integer> v) {
        if (root == null) return;
        inOrder(root.left, v);
        v.add(root.data);
        inOrder(root.right, v);
    }

    boolean checkBST(Node root) {
        Vector<Integer> v = new Vector<>();
        inOrder(root, v);
        int n = v.size();
        for (int i = 0; i < n - 1; i++) {
            if (v.get(i) >= v.get(i + 1)) return false;
        }
        return true;
    }

    void inOrder(Node root, int levels) {
        if (root != null) {
            if (levels > 0) {
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }
            root.data = values.elementAt(count);
            count++;
            if (levels > 0) {
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int height = scanner.nextInt();
        Tree tree = new Tree();
        while (scanner.hasNext()) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();
        Node root = new Node();
        tree.inOrder(root, height);
        System.out.println(tree.checkBST(root) ? "Yes" : "No");
    }
}

