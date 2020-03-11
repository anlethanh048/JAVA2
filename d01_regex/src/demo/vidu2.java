/*
 vi du bieu thuc chinh quy
 Kiem tra sdt hop le khong
 sdt hop le: chứa các ký số hoặc khoảng trắng, it nhất 3 số
 */
package demo;

import java.util.Scanner;
import java.util.regex.*;

public class vidu2 {

    public static void main(String[] args) {
        //1. tao mau qui luat(qui tac) cho số điện thoại
        Pattern p = Pattern.compile("[ 0-9]{3,}");
        //2. tao doi tuong de thuc hien kiem tra
        Matcher m = null;

        String sdt = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Nhap Số điện thoại: ");
            sdt = sc.nextLine().trim();

            //3. khoi tao doi tuong matcher m, 
            //   de tien hanh viec kiem tra so khop "p" voi "sdt"
            m = p.matcher(sdt);

            //4. kiem tra
            if (m.matches()) {
                System.out.println("SDT nhap hop le");
                break;
            }
            //thong bao loi
            System.out.println("SDT ko hop le, Vui long nhap lai !!!");
        }
    }

}
