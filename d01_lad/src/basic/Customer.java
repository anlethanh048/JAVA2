/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Customer {
    public String name,id,phone,address;
    public int yob;
//hàm dựng không tham số
    public Customer() {
    }
// Hàm dựng có tham số
    public Customer(String name, String id, String phone, String address, int yob) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.yob = yob;
    }
    //Hàm nhập dữ liệu chi tiết cho khách hàng
    public void input(){
         
        Scanner in = new Scanner(System.in);
        //1.Nhập kiểm tra id khách hàng: Cxxxx vói x là ký số
        Pattern p = Pattern.compile("C\\d{4}");// Tạo mẫu chính qui
         Matcher m = null;
        while(true){
            try {
                System.out.println("Nhập id: ");
                id = in.nextLine().trim();
                //Khởi tạo m để so sánh khớp mẫu p với id
                 m = p.matcher(id);
                //Thực hiện so khớp
                if(m.find()){
                    break; //Nếu id có nội dung trùng khớp với mẫu p->Dữ liệu hợp lệ -> Thoát vòng lặp
                }else{
                    throw new InvalidDataException("ID phải có dạng Cxxxx. x là 1 ký số!");
                }
                
            } catch (InvalidDataException e) {
                System.out.println("Lỗi: "+e.getMessage());
            }
        }
        //Nhập và kiểm tra tên khách hàng: ít nhất 2 ký tự
         p = Pattern.compile("[a-z A-Z]{2,}");// Khởi tạo mẫu chính qui
         m = null;
             while(true){
                 try {
                      System.out.println("Nhập tên khách hàng:");
                 name = in.nextLine().trim();
                 m = p.matcher(name);
                 if(m.find()){
                     break;
                 }
                 else{
                     throw new InvalidDataException("Tên ít nhất phải có hai ký tự a-z");
                 }
                 } catch (InvalidDataException e) {
                     System.out.println("Lỗi: "+ e.getMessage());
                 }
             }
              // Nhập kiểm tra sdt 3-10
             p = Pattern.compile("\\d{3,10}");// khởi tạo lại mẫu chính qui
             m = null;
             while(true){
                 try {
                     System.out.println("Nhập số điện thoại:");
                     phone = in.nextLine().trim();
                     m = p.matcher(phone);
                     if(m.find()){
                         break;
                     }else{
                         throw new InvalidDataException("Số điện thoại phải từ 3-10 ký số");
                     }
                 } catch (Exception e) {
                     System.out.println("Lỗi:"+ e.getMessage());
                 }
             }
             // Nhập địa chỉ
             while(true){
                 try {
                     System.out.println("Nhập địa chỉ:");
                     address = in.nextLine().trim();
                     break;
                 } catch (Exception e) {
                     System.out.println("Lỗi" + e.getMessage());
                 }
             }
           
               //5. Nhập năm sinh
              int namHienTai = java.time.Year.now().getValue();
          int tuoi =0;
               while(true){
                   try {
                             System.out.println("Nhập nam sinh:");
                   yob = Integer.parseInt(in.nextLine().trim());
                   tuoi = namHienTai-yob;
                   if(tuoi>=6&&tuoi<=100){
                       break; //nếu nam sinh nhập hợp lệ và thoát vòng lặp
                   }
                   else{
                       throw new InvalidDataException("Năm sinh không hợp lệ!!!");
                   }
                   } catch (InvalidDataException e) {
                       System.out.println("Lỗi:"+ e.getMessage());
                   }
             }
           
             }   
    public String standradlizeAddress(){
        return address.replaceAll("Q.|q.", "Quận ");
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s - %d",id,name,standradlizeAddress(),phone,yob);
    }
    
    }
    
    

