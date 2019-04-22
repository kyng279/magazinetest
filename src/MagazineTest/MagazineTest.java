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
public class MagazineTest {

    /**
     * @param args the command line arguments
     */
    static private Supplement supplement1 = new Supplement("Sports", 4.00);
    static private Supplement supplement2 = new Supplement("Politics",3.00);
    static private Supplement supplement3 = new Supplement("Science",3.50);
    static private Supplement supplement4 = new Supplement("News",2.50);
    static private Supplement supplement5 = new Supplement("Art",3.50);
    static private ArrayList<Customer> customers = new ArrayList<Customer>();
    
    public static void main(String[] args) {
        
        PayingCustomer customer1 = new PayingCustomer();
        customer1.setName("Ben Smith");
        customer1.setEmail("ben@gmail.com");
        customer1.setIsPayingCustomer(true);
        customer1.setPaymentMethod("Credit Card");
        customer1.addActiveSupplement(supplement1);
        customer1.addActiveSupplement(supplement2);
        customer1.addActiveSupplement(supplement3);
        customer1.addAssociate("ryan@gmail.com");
        customer1.addAssociate("mj@gmail.com");       
        
        AssociateCustomer customer2 = new AssociateCustomer();
        customer2.setName("Ryan Jones");
        customer2.setEmail("ryan@gmail.com");
        customer2.setIsPayingCustomer(false);
        customer2.addActiveSupplement(supplement1);
        customer2.addActiveSupplement(supplement3);
        customer2.addActiveSupplement(supplement4);
        
        AssociateCustomer customer3 = new AssociateCustomer();
        customer3.setName("Michael Jackson");
        customer3.setEmail("mj@gmail.com");
        customer3.setIsPayingCustomer(false);
        customer3.addActiveSupplement(supplement5);
        customer3.addActiveSupplement(supplement1);
        customer3.addActiveSupplement(supplement3);
                
        ArrayList<Customer> customers_test = new ArrayList<Customer>();
        customers_test.add(customer1);
        customers_test.add(customer2);
        customers_test.add(customer3);

        ArrayList<Supplement> supplements_test = new ArrayList<Supplement>();
        supplements_test.add(supplement1);
        supplements_test.add(supplement2);
        supplements_test.add(supplement3);
        supplements_test.add(supplement4);
        supplements_test.add(supplement5);
        
       MagazineService test = new MagazineService(5.0,customers_test,supplements_test);
       
       
       test.outputMonthlyBill(customer1);
 
       
        
        
        
        
    }
}
    
