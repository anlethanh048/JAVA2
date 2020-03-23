package simple;

/*
thu nghiem hoat dong cua thread DemM1 va DemM2
 */
public class Demo2 {

    public static void main(String[] args) {
       
        //khoi tao thread DemM1
        DemM1 t = new DemM1();
        Thread t1 = t;
        //dat ten cho t1
        t1.setName("Huy");
        
        
        //khoi tao thread DemM2
        Thread t2 = new Thread(new DemM2());
        //dat ten cho t2
        t2.setName("Thu");
        
        //ra linh cho t1 va t2 hoat dong
//        t1.run();
//        t2.run();
        t1.start();
        t2.start();
        
        int dem = Thread.activeCount();
        System.out.printf("So luong thread dang hoat dong tot: v%d\n",dem);
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
           ex.printStackTrace();
        }
        System.out.println("\n ****Main thread Finished!!!");
        
    }
    
}
