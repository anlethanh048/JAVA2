package data;

import java.util.Scanner;

public class Test {

    public void menu() {
      Produccatalog c =  new Produccatalog();
     c.readFile();
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("========MENU========");
            System.out.println("1. Them san pham moi");
            System.out.println("2. Nhap kho 1 sp");
            System.out.println("3. Xuat kho 1 sp");
            System.out.println("4. In thong bao ton kho");
            System.out.println("5. luu ds ton kho vo file");
            System.out.println("6. Thoat");
            System.out.println("\tChon chuc nang[1-6]");
            String op = in.nextLine().trim();
            switch (op) {
                case "1":
                    c.add();
                    break;
                case "2":
                    boolean isreceve=true;
                    System.out.println("Nhap Ma sp:");
                    String sID = in.nextLine().trim();
                    System.out.println("Nhap so luong:");
                    float sQty = Float.parseFloat(in.nextLine().trim());
                    c.set(sID, sQty, isreceve);
                    break;
                case "3":
                    isreceve=false;
                    System.out.println("Nhap Ma sp:");
                     sID = in.nextLine().trim();
                    System.out.println("Nhap so luong:");
                    sQty = Float.parseFloat(in.nextLine().trim());
                    c.set(sID, sQty, isreceve);
                    break;
                case "4":
                    c.display();
                    break;
                case "5":
                    c.saveFile();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Chon sai chuc nang!!!");
                    break;
            }

        }
         

    }

    public static void main(String[] args) {
        Test c = new Test();
        c.menu();

    }

}
