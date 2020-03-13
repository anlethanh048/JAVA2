/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import basic.CustomerList;
import java.util.Scanner;


public class TestCustomer {

    public void menu() {
        Scanner in = new Scanner(System.in);
        CustomerList c = new CustomerList();
        while (true) {
            System.out.println("*-*-*-MENU-*-*-*-*");
            System.out.println("1. Them 1 khách hàng");
            System.out.println("2. Hiển thị tất cả thông tin danh sách khách hàng");
            System.out.println("3. Tìm kiếm khách hàng theo tên");
            System.out.println("4. Thoát");
            System.out.println("\t Chọn chức năng [1-4]");
            String op = in.nextLine().trim();
            switch (op) {
                case "1":
                    c.add();
                    break;
                case "2":
                    c.displayAll();
                    break;
                case "3":
                    System.out.println("Nhập tên muốn tìm kiếm:");
                    String ename = in.nextLine().trim();
                    c.searchbyName(ename);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Chọn sai chức nhăng!!! chọn lại.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        TestCustomer c = new TestCustomer();
        c.menu();

    }

}
