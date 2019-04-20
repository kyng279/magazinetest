/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagazineTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author Ky.Nguyen
 */
public final class MagazineService {
    private double baseWeeklyCost;
    private ArrayList<Customer> customers;
    private ArrayList<Supplement> supplements;
    
    //constructor
    public MagazineService(double baseWeeklyCost, ArrayList<Customer> customers,
            ArrayList<Supplement> supplements){
        setBaseWeeklyCost(baseWeeklyCost);
        setCustomers(customers);
        setSupplements(supplements);
    }
    //default constructor
    public MagazineService(){
        this.baseWeeklyCost = 0;
        this.customers = new ArrayList<Customer>();
        this.supplements = new ArrayList<Supplement>();
    }
    //outputs weekly email for a customer 
    public void outputWeeklyEmail(int i){
        Customer x = this.customers.get(i);
        System.out.printf("Hello %s, \n",x.getName());
        System.out.println("Your weekly Magazine and supplements are available"
                + " for viewing");
        System.out.println("You are currently subscribed to the following "
                + "supplements:");
        for(int j = 0; j < x.getActiveSupplements().size(); j++){
            System.out.println(x.getActiveSupplements().get(j).getName());
        }          
    }
    //outputs weekly email for all customers
    public void outputAllWeeklyEmail(){
        for(int i =0;i<customers.size();i++){
            this.outputWeeklyEmail(i);
            System.out.println();
        }   
    }

        
    //outputs end of month email for paying customer
    public void outputMonthlyBill(Customer x){
        
        System.out.println("Base weekly charge: $5");
        for(int j = 0; j < x.getActiveSupplements().size(); j++){
            System.out.println(x.getActiveSupplements().get(j).getName() +
                    " $" + x.getActiveSupplements().get(j).getWeeklyCost());
        }
        System.out.println("Total Weekly Charge:" + getCustomerWeeklyCharge(x));
    }
    //returns the total weekly amount a customer is subscribed to (base + supplements)
    public double getCustomerWeeklyCharge(Customer customer){
        double weeklyCharge = this.baseWeeklyCost;
        for(int i = 0; i < customer.getActiveSupplements().size();i++){
            weeklyCharge += customer.getActiveSupplements().get(i).getWeeklyCost();
        }
        return weeklyCharge;
    }
  
    
    public void setBaseWeeklyCost(double cost){
        this.baseWeeklyCost = cost;
    }
    public void setCustomers(ArrayList<Customer> customers){
        this.customers = customers;
    }
    public void setSupplements(ArrayList<Supplement> supplements){
        this.supplements = supplements;
    }
    public ArrayList<Supplement> getSupplements(){
        return this.supplements;
    }
    public ArrayList<Customer> getCustomers(){
        return this.customers;
    }
    public double getBaseWeeklyCost(){
        return this.baseWeeklyCost;   
    }
    public void addSupplement(Supplement supplementName){
        this.supplements.add(supplementName);
    }
    public void removeSupplement(int i){
        this.supplements.remove(i);
    }
    public void addCustomer(Customer customerName){
        this.customers.add(customerName);
    }
    public void removeCustomer(int i){
        this.customers.remove(i);
    }
    
}
