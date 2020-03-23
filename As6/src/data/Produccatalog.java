package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produccatalog {

    Map<String, Product> plist = new HashMap<>();
    String fname = "TONKHO.DAT";

    public void readFile() {
        File f = new File(fname);
        if (f.exists() == false) {
            System.out.println("Khong tin thay file!!!");
            return;
        }
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            plist = (Map<String, Product>) ois.readObject();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Produccatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Produccatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Produccatalog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void add() {
        Product c = new Product();
        c.input();
        if (plist.containsKey(c.id)) {
            System.out.println("ID da ton tai tua choi them moi!!!");
            return;
        }
        plist.put(c.id, c);

    }

    public void set(String sID, float sQty, boolean isreceve) {
        Product c = new Product();
        int dem = 0;
        if (isreceve == true) {
            for (Product pd : plist.values()) {
                if (pd.id.equals(sID)) {
                    pd.in_qty += sQty;
                    dem++;
                }
            }
        } else {
            for (Product pd : plist.values()) {
                if (pd.id.equals(sID)) {
                    pd.out_qty += sQty;
                    dem++;
                }
            }
        }
        if (dem == 0) {
            System.out.println("Khong tim thay sp co ma " + sID);
        }
    }

    public void display() {
        if (plist.isEmpty()) {
            System.out.println("He thong chua co du lieu!!!");
            return;
        }
        for (Product pd : plist.values()) {
            pd.output();
        }
    }

    public void saveFile() {
        try {
            FileOutputStream fos = new FileOutputStream(fname);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(plist);
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Produccatalog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Produccatalog.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
