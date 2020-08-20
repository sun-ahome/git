package com.test.numone;

import java.util.Scanner;

public class GitTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入成绩");
        int num = scanner.nextInt();
        if (num >= 90) {
            System.out.println("A");
        } else if (num < 60) {
            System.out.println("C");
        } else {
            System.out.println("B");
        }
    }
}
