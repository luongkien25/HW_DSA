package edu.HW_DSA.BT_10;
import java.util.*;
import java.io.*;

class BST_LCA {

    public static Node lca(Node root, int v1, int v2) {
        if (v1 > v2) {
            int tmp = v1; v1 = v2; v2 = tmp;
        }
        Node cur = root;
        while (cur != null) {
            if (v2 < cur.data) {
                cur = cur.left;
            } else if (v1 > cur.data) {
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
