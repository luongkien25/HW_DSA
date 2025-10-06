package edu.HW_DSA.week5;

import java.util.*;

public class JavaSort {
    static class Student {
        int id;
        String name;
        double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();
            double cgpa = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(id, name, cgpa));
        }

        Collections.sort(students, (s1, s2) -> {
            if (Double.compare(s2.cgpa, s1.cgpa) != 0) {
                return Double.compare(s2.cgpa, s1.cgpa);
            }
            if (!s1.name.equals(s2.name)) {
                return s1.name.compareTo(s2.name);
            }
            return Integer.compare(s1.id, s2.id);
        });

        for (Student student : students) {
            System.out.println(student.name);
        }

        sc.close();
    }
}