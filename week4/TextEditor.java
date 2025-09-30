package edu.HW_DSA.week4;
import java.util.*;

import java.util.*;

public class TextEditor {
    private StringBuilder text;
    private Stack<Command> history;

    private class Command {
        String type;
        String data;
        int length;

        Command(String type, String data, int length) {
            this.type = type;
            this.data = data;
            this.length = length;
        }
    }

    public TextEditor() {
        text = new StringBuilder();
        history = new Stack<>();
    }

    public void append(String str) {
        text.append(str);
        history.push(new Command("append", str, 0));
    }

    public void delete(int k) {
        String deleted = text.substring(text.length() - k);
        text.delete(text.length() - k, text.length());
        history.push(new Command("delete", deleted, k));
    }

    public void print(int i) {
        System.out.println(text.charAt(i - 1));
    }

    public void undo() {
        if (!history.isEmpty()) {
            Command last = history.pop();

            if (last.type.equals("append")) {
                text.delete(text.length() - last.data.length(), text.length());
            } else if (last.type.equals("delete")) {
                text.append(last.data);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int j = 0; j < n; j++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            int cmd = Integer.parseInt(parts[0]);

            if (cmd == 1) {
                String str = parts[1];
                editor.append(str);
            } else if (cmd == 2) {
                int k = Integer.parseInt(parts[1]);
                editor.delete(k);
            } else if (cmd == 3) {
                int index = Integer.parseInt(parts[1]);
                editor.print(index);
            } else if (cmd == 4) {
                editor.undo();
            }
        }
    }
}
