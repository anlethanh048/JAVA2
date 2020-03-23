/*
 hoat dong nhu 1 thread - don gian la in ra 1 chuoi so nguyen tu 9-0
 */

package simple;

public class DemM2 implements Runnable{

    //ham run() se chua cac cau linh ma thread phai thuc hien
    @Override
    public void run() {
        String ten = Thread.currentThread().getName();
        System.out.println("Ten cua Thread : " + ten );
        System.out.println(">> 10 so nguyen dau tien (9-0) :");
        for (int i = 9; i >=0; i--) {
            System.out.printf("\t\t %s: %3d \n", ten, i);
            try {
                Thread.sleep(700);  //nghi 700ms
            } catch (InterruptedException ex) {
                System.out.println("Loi: " + ex.getMessage());
            }
        }
    }
    
}
