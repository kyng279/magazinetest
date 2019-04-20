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
class PayingCustomer extends Customer {
    private String paymentMethod;
    private ArrayList<AssociateCustomer> associates;
    
    //Constructor
    public PayingCustomer(String name, String email, 
            ArrayList<Supplement> activeSupplements,Boolean isPayingCustomer,String paymentMethod,
            ArrayList<AssociateCustomer> associates){
        super(name, email, activeSupplements, isPayingCustomer);
        this.setPaymentMethod(paymentMethod);
        this.setAssociates(associates);
    }
    //default Constructor
    public PayingCustomer(){
        super();
        this.associates = new ArrayList<AssociateCustomer>();
        this.paymentMethod = "";
    }
    public String getPaymentMethod(){
        return this.paymentMethod;
    }
    public ArrayList<AssociateCustomer> getAssociates(){
        return this.associates;
    }
    public void addAssociate(AssociateCustomer associateName){
        this.associates.add(associateName);
    }
    public void removeAssociate(int i){
        this.associates.remove(i);
    }
    public void setPaymentMethod(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public void setAssociates(ArrayList<AssociateCustomer> associates){
        this.associates = associates;
    }
    
}
