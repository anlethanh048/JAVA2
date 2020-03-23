package simple;
public class Demo1 {
    public String getName(){
        return "huy";
    }

    public static void main(String[] args) {
        //lay ten cua main thread
        String ten = Thread.currentThread().getName();
      
        //dem co bn thread dang chay trong chuong trinh / ung dung Demo1
        int dem = Thread.activeCount();
        
        System.out.printf("Ten cua main thread: %s \n", ten);
        System.out.printf("So luong thread dang hoat dong: %d \n", dem);
        
        m1();
        m2();
        
    }
    
    
    static void m1(){
        System.out.println(">> 10 so nguyen dau tien (0-9) :");
        for (int i = 0; i < 10; i++) {
            System.out.printf("\t M1: %3d \n", i);
        }
    }
    
    static void m2(){
        System.out.println(">> 10 so nguyen dau tien (9-0) :");
        for (int i = 9; i >=0; i--) {
            System.out.printf("\t\t M2: %3d \n", i);
        }
    }
}
