package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;
import java.util.TreeSet;

public class EmployeeList {

    Set<Employee> empList = new TreeSet<>();
    String filename = "VN.txt";

    public EmployeeList() {
    }

    public void seveFile() {
        try {
            PrintStream oput = new PrintStream(filename);
            // doc het du lieu empList ghi vo filename;
            for (Employee conten : empList) {
                oput.print(conten);
            }
            oput.close();//rat quan trong...

        } catch (Exception e) {
            System.out.println("Loi " + e.getMessage());
        }

    }

    public void addEmp() {
    
        Employee e = new Employee();
        e.input();
        empList.add(e);
    }

    public boolean searchByName() {
        boolean kq = false;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhap ten nhan vien muon tim kiem:");
        String ename = in.nextLine().trim();
        int dem = 0;
        String tennv = ename.toLowerCase();
        for (Employee nv : empList) {
            
            if (nv.name.toLowerCase().contains(tennv)) {
                System.out.println(nv);
                dem++;
                
            }
        }
        if (dem > 0) {
            System.out.println("Tim thay " + dem + "nhan vien co ten chua " + tennv);
            kq = true;
        } else {
            System.out.println("Khong tim thay nhan vien nao");
            kq = false;
        }
        return kq;
    }
 
    public void display() {
       
        if (empList.isEmpty()) {
            System.out.println("he thong chua co du lieu");
            return;// thoat khoi he thong
        }
           
        for (Employee nv : empList) {
            
            System.out.println(nv.toString());
        }
    }

    public void display(int years) {
        LocalDate locaDate = LocalDate.now();
        int year = locaDate.getYear();
        if (empList.isEmpty()) {
            System.out.println("he thong chua co du lieu");
            return;// thoat khoi he thong
        }
        int dem = 0;
        for (Employee nv : empList) {
            if ((year - nv.joinedYear) > years) {
                System.out.println(nv.toString());
                dem++;
            }
        }
        if (dem > 0) {
            System.out.println("Tim thay " + dem + "co nam kinh nghiem lon hon" + years);
        } else {
            System.out.println("Khong tim thay nhan vien nao");
        }
    }

    public void readFileText() {
        //kiem tra xem tap tin "NV.txt" co chua ?
        File f = new File(filename);
        if (f.exists() == false) {
            return; //tap tin chua co -> ket thuc ha doc file
        }

        try {
            //1. mo luong input de doc noi dung file "nhanvien.txt"
            BufferedReader br = new BufferedReader(new FileReader(f));

            //2. doc tung dong, phan tich tao thanh doi tuong nv, luu vo ds
            String line = null;
            String[] items;
            while (br.ready()) {
                line = br.readLine();
                items = line.split(",");
                if (items.length == 4) {
                    // tao doi tuong nv tu dong du lieu doc tu file
                    Employee emp = new Employee();
                    emp.id = items[0].trim();
                    emp.name = items[1].trim();
                    emp.salary = Integer.parseInt(items[2].trim());
                    emp.joinedYear = Integer.parseInt(items[3].trim());

                    // dua nv vo ds
                    empList.add(emp);
                }
            }

            //3. doc het file, dong luong input
            br.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        EmployeeList c = new EmployeeList();
        do {
            System.out.println("*-*-CT Quan Ly DS Nhan Vien-*-*");
            System.out.println("1. Them Nhan vien moi");
            System.out.println("2. Tim kiem nhan vien theo ten");
            System.out.println("3. Liet ke tat ca nhan vien trong cty");
            System.out.println("4. Liet ke tat ca nhan co tham nien cong tac tuy chon");
            System.out.println("5. ghi file");
            System.out.println("6. Doc file");
            System.out.println("7. Thoat");
            System.out.println("\tChon chuc nang[1-7]");
            String op = in.nextLine().trim();
            switch (op) {
                case "1":
                    c.addEmp();
                    break;
                case "2":
                    c.searchByName();
                    break;
                case "3":
                    c.display();
                    break;
                case "4":
                    
                        System.out.println("Nhap so nam tham nien:");
                        int years = Integer.parseInt(in.nextLine().trim());
                    c.display(years);
                        break;
                    

            }
        } while (true);

    }

}
