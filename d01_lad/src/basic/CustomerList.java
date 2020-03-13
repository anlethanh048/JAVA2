/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basic;

/**
 *
 * @author LENOVO
 */
public class CustomerList {

    int max = 10;
    int next = 0;
    Customer[] cList = new Customer[max];

    // Thêm một khách hàng vào danh sách
    public void add() {
        if (next == max) {
            System.out.println("Dữ liệu đầy!!!Từ chối thêm mới!!");
            return;// thoát vòng lặp
        }
        Customer c = new Customer();
        c.input();
        cList[next] = c;
        next++;
    }

    // In tất cả các danh sách ra màn hình
    public void displayAll() {
        if (next == 0) {
            System.out.println("Hệ thông chưa có dữ liệu!");
            return;// Thoat vòng lặp
        }
        for (int i = 0; i < next; i++) {
            System.out.println(cList[i].toString());
        }

    }

    public void searchbyName(String ename) {
        if (next == 0) {
            System.out.println("Hệ thông chưa có dữ liệu!");
            return;// Thoat vòng lặp
        }
        int cnt_name = 0;
        for (int i = 0; i < next; i++) {
            if (cList[i].name.equalsIgnoreCase(ename)) {
                System.out.println(cList[i].toString());
                cnt_name++;
            }
        }
        if (cnt_name > 0) {
            System.out.println("Có" + cnt_name + "Khách hàng có tên chứa" + ename + "được tìm thấy");
        } else {
            System.out.println("không có khách hàng nào có tên chứa" + ename + "được tìm thấy");

        }
    }

}
