package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterOutputStream;
import sun.applet.Main;

public class DoctorManager {

    Map<String, Doctor> dtList = new TreeMap<>();
    String fname = "DT.dat";

    public void menu() {
        readFile();
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("========MENU=========");
            System.out.println("1. Dang ky bac si moi");
            System.out.println("2. Tim kiem bac si theo ten");
            System.out.println("3. In ds bac si");
            System.out.println("4. Ghi File");
            System.out.println("5. Thoat");
            System.out.println("\tChon chuc nang[1-5]");
            String op = in.nextLine().trim();
            switch (op) {
                case "1":
                    add();
                    break;
                case "2":
                    System.out.println("Nhap ID bac si muon tim kiem.");
                    String ID = in.nextLine().trim();
                    display(ID);
                    break;
                case "3":
                    display();
                    break;
                case "4":
                    saveFile();
                    break;             
                case "5":
                    return;
                default:
                    System.out.println("Chon sai chuc nang!!!");
                    break;

            }
        } while (true);

    }

    public void add() {
        Doctor c = new Doctor();
        c.input();
        if (dtList.containsKey(c.id)) {
            System.out.println("Ma Id ton tai.Tu choi them moi!!");
            return;
        }
        dtList.put(c.id, c);
    }

    public void display() {
        if (dtList.isEmpty()) {
            System.out.println("he thong chua co du lieu!!!");
            return;
        }
        for (Doctor dt : dtList.values()) {
            System.out.println(dt);
        }
    }

    public void display(String ID) {

        if (dtList.isEmpty()) {
            System.out.println("he thong chua co du lieu!!!");
            return;
        }
     if(dtList.containsKey(ID)){
         System.out.println("Bac si co ma so duoc tim thay la.");
         System.out.println(dtList.get(ID));
     }
     else{
         System.out.println("khong tim thay bac si nao co ma so la "+ID);
     }
    }
    public void saveFile(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fname);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(dtList);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(DoctorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Nen file
          String nen ="DT.zip";
        try {
            java.nio.file.Path p = java.nio.file.Paths.get(fname);
            FileOutputStream fo = new FileOutputStream(nen);
            java.util.zip.DeflaterOutputStream dos = new DeflaterOutputStream(fo);
            dos.write(java.nio.file.Files.readAllBytes(p));
            dos.flush();
            dos.close();
            System.out.println("Nen File thanh cong");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        File f = new File(fname);
        if(f.exists()==false){
            System.out.println("Khong tim thay tap tin!!!");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            dtList= (Map<String,Doctor>)ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DoctorManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DoctorManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DoctorManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void giaiNenFile(){
         String compressName ="DT.zip" ;
        String txtName = "DT.txt";
              try {
            java.nio.file.Path p = java.nio.file.Paths.get(compressName);
            
            java.io.FileOutputStream fos = new FileOutputStream(txtName);
            java.util.zip.InflaterOutputStream os = new InflaterOutputStream(fos);
            os.write(java.nio.file.Files.readAllBytes(p));
            
            os.flush();
            os.close();
            
               System.out.println("Giai nen thanh cong!!!");
        } catch (Exception ex) {
            System.out.println("Loi: " + ex.getMessage());
        }
    }
    
    
    public static void main(String[] args) {
        DoctorManager a = new DoctorManager();
        a.menu();
    }
    
}
