
package data;

import java.io.Serializable;
import java.util.Scanner;


public class Doctor implements Serializable{
    public String id,name,specialization;
    public int avaiHours;

    public Doctor() {
    }

    public Doctor(String id, String name, String specialization, int avaiHours) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
        this.avaiHours = avaiHours;
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Nhap ID:");
            id = in.nextLine().trim();
            if(id.length()>0){
                break;
            }
            else{
                System.out.println("ID khong hop le!!!");
            }
        }
        while(true){
            System.out.println("Nhap Name:");
            name = in.nextLine().trim();
            if(name.length()>0){
                break;
            }
            else{
                System.out.println("Name khong hop le!!!");
            }
        }
        while(true){
            System.out.println("Nhap Specialization:");
            specialization = in.nextLine().trim();
            if(specialization.length()>0){
                break;
            }
            else{
                System.out.println("Specialization khong hop le!!!");
            }
        }
        while(true){
            try {
                System.out.println("Nhap avaiHours:");
                avaiHours = Integer.parseInt(in.nextLine().trim());
                if(avaiHours>=0){
                    break;
                }
                else{
                    throw new Exception("AvaiHours khong hop le!!!");
                            
                }
            } catch (Exception e) {
                System.out.println("Loi" +e.getMessage());
            }
        }
        
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nName: %s\nSpeciation: %s\nAvaiHours: %d\n",id,name,specialization,avaiHours);
    }

    @Override
    public boolean equals(Object obj) {
        Doctor d = (Doctor)obj;
        return this.id.equals(d.id);
    }

    @Override
    public int hashCode() {
        return 100; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
