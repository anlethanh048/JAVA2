/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;


public class ProductList {
    int max =5;
    int next=0;
    Product[]prList = new Product[max];
    public void addProduct(){
        if(next==max){
            System.out.println("dữ lệu đã dầy. Từ chối thêm mới!");
            return;
        }
        Product c = new Product();
        c.input();
        prList[next]=c;
        next++;
    }
    public void displayAll(){
        if(next==0){
            System.out.println("Hệ thống chưa có dữ liệu!!");
            return;
        }
        for (int i = 0; i < next; i++) {
            System.out.println(prList[i].toString());
        }
    }
    public void Search(String ename){
           if(next==0){
            System.out.println("Hệ thống chưa có dữ liệu!!");
            return;
        }
           int cntname =0;
          for (int i = 0; i < next; i++) {
              if(prList[i].name.equalsIgnoreCase(ename)){
                  System.out.println(prList[i].toString());
                  cntname++;
              }
            
        }  
          if(cntname >0){
              System.out.println("Có" + cntname + " sản phẩm có tên" + ename + "được tìm thấy");
          }else{
              System.out.println("không có sản phẩm nào có tên"+ ename);
          }
    }
}


               