
import java.io.FileOutputStream;
import java.util.zip.DeflaterOutputStream;




public class CompressFile2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String vb ="baihat2.txt";
        String nen ="huy.zip";
        try {
            java.nio.file.Path p = java.nio.file.Paths.get(vb);
            java.io.FileOutputStream fos = new FileOutputStream(nen);
            java.util.zip.DeflaterOutputStream dos = new DeflaterOutputStream(fos);
            dos.write(java.nio.file.Files.readAllBytes(p));
            dos.flush();
            dos.close();
            System.out.println("Nen File thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
      
    }
    
}
