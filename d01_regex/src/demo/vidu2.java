/*
 Ví dụ biểu thức chính quy
 Kiểm tra số điện thoại hợp lệ hay không
 SDT hợp lệ: chứa các ký số hoặc khoảng trắng, it nhất 3 số
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

            //3. Khởi tạo đối tượng matcher m, 
            //   Để tiến hành kiểm tra số khớp p "p" với "sdt"
            m = p.matcher(sdt);

            //4. kiem tra
            if (m.find()) {
                System.out.println("SDT nhap hop le");
                break;
            }
            //thong bao loi
            System.out.println("SDT ko hop le, Vui long nhap lai !!!");
        }
    }

}
