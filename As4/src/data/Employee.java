
package data;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Employee implements Comparable<Employee>{
    public String id,name,address;
    public int salary,joinedYear;

    public Employee() {
    }

    public Employee(String id, String name, String address, int salary, int joinedYear) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.joinedYear = joinedYear;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        String EmployeeInfo = "\nMax so: "+id;
        EmployeeInfo += "\n Ten nhan vien: "+name;
        EmployeeInfo += "\nDia chi: "+ address;
        EmployeeInfo += "\nLuong: "+salary;
        EmployeeInfo += "\nNam vao cty: "+joinedYear ;
        return EmployeeInfo;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        Pattern p = Pattern.compile("EM\\d{4,}");
        Matcher m =null;
        while(true){
            System.out.println("Nhap ma ID:");
            id = in.nextLine().trim();
            m = p.matcher(id);
            if(m.matches()){
                break;
            }
            else{
                System.out.println("ID khong hop le!! Vui long nhap lai!");
            }
        }
        while(true){
            System.out.println("Nhap ten nhan vien:");
            name = in.nextLine().trim();
            if(name.length()>0){
                break;
            }else{
                System.out.println("Ten khong duoc de trong.");
            }
        }
        while(true){
            System.out.println("Nhap dia chi:");
            address = in.nextLine().trim();
            if(address.length()>0){
                break;
            }else{
                System.out.println("Dia chi khong duoc de trong.");
            }
        }
        while(true){
            try {
                System.out.println("Nhap luong[100-1000]:");
                salary = Integer.parseInt(in.nextLine().trim());
                if(salary >=100&&salary<=1000){
                    break;
                }else{
                    throw new Exception("Luong khong hop le!");
                }
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
            }
            
        }
        while(true){
            try {
                System.out.println("Nhap nam vao cong ty[1980-2020]:");
                joinedYear = Integer.parseInt(in.nextLine().trim());
                if(joinedYear >=1980&&joinedYear<=2020){
                    break;
                }else{
                    throw new Exception("Nam vao cong ty khong hop le!");
                }
            } catch (Exception e) {
                System.out.println("Loi " + e.getMessage());
            }
            
        }
        
    }

    @Override
    public boolean equals(Object obj) {
        Employee e = (Employee)obj;
        return(this.id.equals(e.id));
    }
       @Override
    public int hashCode() {
        return 100;
    
    }

    @Override
    public int compareTo(Employee o) {
        return this.id.compareTo(o.id);
    }

   
}
