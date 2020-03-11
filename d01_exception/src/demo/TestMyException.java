/*
 Lop nay duoc viet ra der kiem thu MyException
 */
package demo;

import basic.MyException;
import java.util.Scanner;

public class TestMyException {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhap vao mot so >0:");
                int n = Integer.parseInt(in.nextLine().trim());
                if (n <= 0) {

                    throw new MyException("Nhap sai roi: nhap so phai >0");
                }
                break;
            } catch (MyException e) {
                System.out.println("Loi:" + e.getMessage());
            }
        }// ket thuc while
        System.out.println("Finish!!");
    }
    
}
