/*
 Day laf lop thong bao loi sai nhap du lieu cua ung dung
 Vi la lop thong bao loi nen la lop con cua lop Exception
 */
package basic;


public class MyException extends Exception{
    //ham dung khong tham so
    public MyException(){
        super("loi sai nhap du lieu !!!");
    }
    // Thong bao loi cu the
    public MyException(String tb){
        super(tb);
    }
    
    
}
