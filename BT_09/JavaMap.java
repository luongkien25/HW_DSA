package edu.HW_DSA.BT_09;

import java.util.*;
import java.io.*;

public class JavaMap {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, String> phoneBook = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine().trim();
            String phone = sc.nextLine().trim();
            phoneBook.put(name, phone);
        }

        while (sc.hasNextLine()) {
            String query = sc.nextLine().trim();
            if (query.isEmpty()) continue;

            if (phoneBook.containsKey(query)) {
                System.out.println(query + "=" + phoneBook.get(query));
            } else {
                System.out.println("Not found");
            }
        }

        sc.close();
    }
}

