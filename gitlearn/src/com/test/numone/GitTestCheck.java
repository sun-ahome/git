package com.test.numone;

import java.util.Scanner;

public class GitTestCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum_rabbit = 1;   //兔子总数
        int one_ago_rabbit = 1;   //1个月前兔子总数
        int two_ago_rabbit = 1;   //2个月前兔子总数
        System.out.println("输入月份");
        int i = scanner.nextInt();
        if (i < 3 ) {
            sum_rabbit = 1;
        } else {
            sum_rabbit = one_ago_rabbit + two_ago_rabbit;
            two_ago_rabbit = one_ago_rabbit;
            one_ago_rabbit = sum_rabbit;
        }
        System.out.println(sum_rabbit);
    }
}
