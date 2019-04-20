/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagazineTest;
import java.util.ArrayList;
/**
 *
 * @author Ky.Nguyen
 */
public class Customer {
    private String name;
    private String email;
    private ArrayList<Supplement> activeSupplements;
    private boolean isPayingCustomer;
    
    //default constructor
    public Customer(){ 
        this.name = "";
        this.email = "";
        this.activeSupplements = new ArrayList<Supplement>();
        this.isPayingCustomer = false;
        
    }
    //constructor
    public Customer(String name, String email, ArrayList<Supplement> activeSupplements,boolean isPayingCustomer){ 
        this.name = name;
        this.email = email;
        this.activeSupplements = activeSupplements;
        this.isPayingCustomer = isPayingCustomer;

    }
    public String getName(){
        return this.name;
    }
    public String getEmail(){
        return this.email;
    }
    public ArrayList<Supplement> getActiveSupplements(){
        return this.activeSupplements;
    }
    public boolean getIsPayingCustomer(){
        return this.isPayingCustomer;
    }
    public void addActiveSupplement(Supplement supplementName){
        this.activeSupplements.add(supplementName);
    }
    public void removeSupplements(int i){
        this.activeSupplements.remove(i);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setActiveSupplements(ArrayList<Supplement> activeSupplements){
        this.activeSupplements = activeSupplements;
    }
    public void setIsPayingCustomer(boolean flag){
        this.isPayingCustomer = flag;
    }
    
}
