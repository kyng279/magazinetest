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
public class AssociateCustomer extends Customer {
    String payingCustomer;
    
    //constructor
    public AssociateCustomer(String name, String email,
            ArrayList<Supplement> activeSupplements,boolean isPayingCustomer,String payingCustomer){
        super(name, email, activeSupplements,isPayingCustomer);
        this.payingCustomer = payingCustomer;
    }
    //default constructor
    public AssociateCustomer(){
        super();
        this.payingCustomer = "";
    }
    public String getPayingCustomer(){
        return this.payingCustomer;
    }
    public void setPayingCustomer(String payingCustomerName){
        this.payingCustomer = payingCustomerName;
    }
    public void removePayingCustomer(){
        this.payingCustomer = "";
    }
}
 