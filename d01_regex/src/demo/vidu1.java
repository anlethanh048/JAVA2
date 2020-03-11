/*
 vi du bieu thuc chinh quy
 Kiem tra gia tri nhap vao co dang thuc hop len voi mọt chuoi ho ten hay khong
 ho ten hop le: khong co ky tu dac biet, không có số-it nhat 1 ký tự
 */
package demo;

import java.util.Scanner;
import java.util.regex.*;

public class vidu1 {

  public static void main(String[] args) {
        //1. tao mau qui luat(qui tac) cho chuoi ho ten hop le
        java.util.regex.Pattern p = Pattern.compile("[a-zA-Z ]{1,30}");
        //2. tao doi tuong de thuc hien tinh nang kiem tra luat p voi chuoi vb bat ky
        java.util.regex.Matcher m = null;
        
        String hoten = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Nhap ho va ten sinh vien: ");
            hoten = sc.nextLine().trim();
            
            //3. khoi tao doi tuong matcher m, 
            //   de tien hanh viec kiem tra so khop "p" voi "hoten"
            m = p.matcher(hoten);
            
            //4. danh gia bang ham matches()/ lookingAt() / find()
            if(m.matches()){
                System.out.println("Ten nhap hop le");
                break;
            }
            //thong bao loi
            System.out.println("Ten ko hop le, Vui long nhap lai !!!");    
        }                   
    }

}
