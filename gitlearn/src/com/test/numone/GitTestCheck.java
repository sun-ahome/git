package com.test.numone;

import java.util.Scanner;

public class GitTestCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum_rabbit = 1;   //兔子总数
        int oneAagoRabbit = 1;   //1个月前兔子总数
        int twoAgoRabbit = 1;   //2个月前兔子总数
        System.out.println("输入月份");
        int i = scanner.nextInt();
        if (i < 3 ) {
            sum_rabbit = 1;
        } else {
            sum_rabbit = oneAagoRabbit + twoAgoRabbit;
            twoAgoRabbit = oneAagoRabbit;
            oneAagoRabbit = sum_rabbit;
        }
        System.out.println(sum_rabbit);
    }
}
