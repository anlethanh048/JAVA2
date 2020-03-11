/*
 Đây là lớp thông báo nhập lỗi sai của ứng dụng
Vì là lớp thông báo lỗi nên là lớp con của Exception
 */
package basic;


public class MyException extends Exception{
    //Hàm dựng không tham số
    public MyException(){
        super("lỗi sai nhập dữ liệu !!!");
    }
    // Thông báo lỗi cụ thể
    public MyException(String tb){
        super(tb);
    }
    
    
}
