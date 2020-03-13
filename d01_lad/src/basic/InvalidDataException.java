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
public class InvalidDataException extends Exception{

    public InvalidDataException() {
        super("Lỗi sai nhập dữ liệu");
    }

    public InvalidDataException(String message) {
        super(message);
    }
    
    
}
