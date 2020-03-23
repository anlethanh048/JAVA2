
package data;

import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Product implements Serializable{
    public String id,name;
    public int price;
    public float in_qty=0,out_qty=0;

    public Product() {
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("P\\d{3,}");
        Matcher m = null;
        while(true){
            System.out.println("Nhap ID [Pxxx]:");
            id = in.nextLine().trim();
            m = p.matcher(id);
            if(m.matches()){
                break;
            }else{
                System.out.println("ID khong hop le!!!");
            }
        }
        while(true){
            System.out.println("Nhap name:");
            name = in.nextLine().trim();
         
            if(name.length()>0){
                break;
            }else{
                System.out.println("Ten khong dduoc de trong!!!");
            }
        }
        while(true){
            try {
                  System.out.println("Nhap don gia:");
            price = Integer.parseInt(in.nextLine().trim());
            if(price>0){
                break;
            }else{
                throw new Exception("Don gia khong hop le!!!");
            }
            } catch (Exception e) {
                System.out.println("Loi "+ e.getMessage());
            }
          
        }
        
    }

    public void output(){
        System.out.printf("Ma: %s,Ten %s,Don gia: %d,Nhap kho: %.2f,Xuat kho: %.2f,Ton Kho: %.2f,Tong gia ton kho: %.2f\n",id,name,price,in_qty,out_qty,(in_qty-out_qty),((in_qty-out_qty)*price));
    }

    @Override
    public String toString() {
        return String.format("Ma: %s,Ten %s,Don gia: %d,Nhap kho: %f,Xuat kho: %f,Ton Kho: %f,Tong gia ton kho: %f",id,name,price,in_qty,out_qty,(in_qty-out_qty),((in_qty-out_qty)*price));
    }
    
    
}
