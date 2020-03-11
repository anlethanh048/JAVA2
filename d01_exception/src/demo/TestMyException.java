/*
Lớp này được viêt ra để kiểm tra MyException
 */
package demo;

import basic.MyException;
import java.util.Scanner;

public class TestMyException {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập vào một số >0:");
                int n = Integer.parseInt(in.nextLine().trim());
                if (n <= 0) {

                    throw new MyException("Nhập sai rồi: nhập số phải >0");
                }
                break;
            } catch (MyException e) {
                System.out.println("Lỗi:" + e.getMessage());
            }
        }// kết thúc while
        System.out.println("Finish!!");
    }
    
}
