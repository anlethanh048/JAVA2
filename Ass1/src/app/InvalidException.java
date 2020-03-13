
package app;


public class InvalidException extends Exception{

    public InvalidException() {
        super("Nhập sai dữ liệu!!!");
    }

    public InvalidException(String message) {
        super(message);
    }
    
    
}
