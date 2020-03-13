package app;

import java.util.Scanner;

public class TestProduct {

    public void menu() {
        Scanner in = new Scanner(System.in);
        ProductList c = new ProductList();
        while (true) {
            System.out.println("=*-/-MENU-/-*=");
            System.out.println("1. Thêm mới một sp");
            System.out.println("2. Hiển thị toàn bộ sp ra màn hình");
            System.out.println("3. Tim kiếm sản phẩm theo tên");
            System.out.println("4. Thoát");
            System.out.println("\t Chọn chức năng [1-4]");
            String op = in.nextLine().trim();
            switch (op) {
                case "1":
                    c.addProduct();
                    break;
                case "2":
                    c.displayAll();
                    break;
                case "3":
                    System.out.println("Nhập tên sản phẩm cần tìm:");
                    String ename = in.nextLine().trim();
                    c.Search(ename);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Giá trị vừa nhập không hợp lệ!!! Nhập lại");
                    break;
            }
        }

    }

    public static void main(String[] args) {
        TestProduct c = new TestProduct();
        c.menu();
    }

}
