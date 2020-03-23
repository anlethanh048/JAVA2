/*
la 1 thread - don gian la in ra 1 chuoi so nguyen tu 0-9
 */
package simple;

public class DemM1 extends Thread{

    //ham run() se chua cac cau linh ma thread phai thuc hien
    @Override
    public void run() {
        String ten = Thread.currentThread().getName();
        System.out.println("Ten cua Thread : " + ten );
        System.out.println(">> 10 so nguyen dau tien (0-9) :");
        for (int i = 0; i < 10; i++) {
            System.out.printf("\t %s: %3d \n", ten, i);
            try {
                Thread.sleep(500);  //nghi 500ms
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }
    }
    
}
