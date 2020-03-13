/*
 vi du ve bieu thuc chinh qui : 
 - kiem tra ma so Nhan Vien co hop le ko ?
   MaNV hop le: bat dau "N" hoac "Q", tiep theo tu 5 ky so.
 - kiem tra chuc vu co hop le hay ko ?
   Chuc vu hop le : hoac la chuoi "nv" hoac "ql" hoac "gd"
 */
package demo;

import java.util.*;
import java.util.regex.*;
public class Vidu3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String manv=null;
        String chucvu =null;
        
        //1. Kiểm tra mã nhân viên
        Pattern p = Pattern.compile("[NQ]\\d{5}");  // \\d <=> [0-9]
        Matcher m = null;
        while(true){
            System.out.print("nhap ma nhan vien: ");
            manv = sc.nextLine().trim();
            
            m= p.matcher(manv);
            if(m.matches()){
                break;
            }
            System.out.println("Mã Nhân Viên Không Hợp Lệ. Phải bắt đầu 'N' hoặc 'Q', sau đó là 5 ky số");
        }//Kết thúc vòng lặp WHILE 
        
        //2. kiểm tra chức vụ hợp lệ
        p = Pattern.compile("(NV|QL|GD)", Pattern.CASE_INSENSITIVE);
        m = null;
        while(true){
            System.out.print("nhap chuc vu nhan vien: ");
            chucvu = sc.nextLine().trim();
            
            m= p.matcher(chucvu);
            if(m.matches()){
                break;
            }
            System.out.println("chuc vu KO HOP LE. Phai 'NV' hoac 'QL', hoac 'GD'");
        }//ket thuc vong lap WHILE 
        
        System.out.println("Thong tin nhan vien: ");
        System.out.println("Ma so: " + manv);
        System.out.println("Chuc vu (viet tat): " + chucvu );
    }
    
}
