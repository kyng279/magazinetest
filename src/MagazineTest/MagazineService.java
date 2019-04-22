/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MagazineTest;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ky.Nguyen
 */
public final class MagazineService {
    private double baseWeeklyCost;
    private ArrayList<Customer> customers;
    private ArrayList<Supplement> supplements;
    
    //hardcoded ArrayList of Supplements
    static private Supplement supplement1 = new Supplement("Sports", 4.00);
    static private Supplement supplement2 = new Supplement("Politics",3.00);
    static private Supplement supplement3 = new Supplement("Science",3.50);
    static private Supplement supplement4 = new Supplement("News",2.50);
    static private Supplement supplement5 = new Supplement("Art",3.50);
    
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
    public void magazineRun(){
        try{
            System.out.println("Magazine Service Program");
            int selection = 0;
            Scanner kb = new Scanner(System.in);
            while(selection != 6){
                System.out.println("Please select from the following options:");
                System.out.println("1)Output weekly emails");
                System.out.println("2)Output monthly emails");
                System.out.println("3)Add a new Customer");
                System.out.println("4)Remove an existing Customer");
                System.out.println("5)Output Student info");
                System.out.println("6)Quit");
                selection = kb.nextInt();
                switch(selection){
                    case 1:
                        this.outputAllWeeklyEmail();
                        System.out.println("Press enter to return to main menu");
                        kb.nextLine();
                        kb.nextLine();
                        break;
                    case 2:
                        this.OutputAllMonthlyEmail();
                        System.out.println("Press enter to return to main menu");
                        kb.nextLine();
                        kb.nextLine();
                        break;
                    case 3:
                        this.inputCustomer();
                        System.out.println("Press enter to return to main menu");
                        kb.nextLine();
                        kb.nextLine();
                        break;
                    case 4:
                        this.inputRemoveCustomer();
                        System.out.println("Press enter to return to main menu");
                        kb.nextLine();
                        kb.nextLine();
                        break;
                    case 5:
                        this.outputStudentInfo();
                        System.out.println("Press enter to return to main menu");
                        kb.nextLine();
                        kb.nextLine();
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choise, please selet again");
                        System.out.println("Press enter to return to main menu");
                        kb.nextLine();
                        kb.nextLine();
                }
            }
        }
        catch(Exception e){
            System.out.println("Error: invalid input detected!");
        }
    }
    public void outputStudentInfo(){
        
    }
    //adds a customer to the customers ArrayList from user input
    public void inputCustomer(){
        Scanner kb = new Scanner(System.in);
        System.out.println("Select customer type:");
        int selection = 0;
        while(selection!=3){
            System.out.println("1)Paying Customer");
            System.out.println("2)Associate Customer");
            System.out.println("3)Cancel");
            selection = kb.nextInt();
            switch(selection){
                case 1:
                    this.inputPayingCustomer();
                    selection=3;
                    break;
                case 2:
                    this.inputAssociateCustomer();
                    selection=3;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid selection! Please try again");
                    
            }   
        }
        
    }
    public void inputAssociateCustomer(){
        AssociateCustomer associateCustomer = new AssociateCustomer();
        this.inputCustomerName(associateCustomer);
        this.inputCustomerEmail(associateCustomer);
        this.inputCustomerSupplements(associateCustomer);
        associateCustomer.setIsPayingCustomer(false);
        Scanner kb = new Scanner(System.in);
        boolean flag = false;
        ArrayList<String> emails = new ArrayList<String>();
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getIsPayingCustomer()){
                emails.add(customers.get(i).getEmail());
                }
        }
        
        while(flag!= true){
            System.out.println("Enter email of associated Paying Customer:");
            System.out.println("Type 'quit' to cancel");
            String email = kb.nextLine();
            if(emails.contains(email)){
                System.out.println("Paying Customer email added");
                flag = true;
                System.out.println("Associated Customer account created");
                this.addCustomer(associateCustomer);
                return;
            }else if(emails.equals("quit")){
                System.out.println("Associate account creation cancelled");
                System.out.println("Returning to main menu");
                flag = true;
                return;
            }
            else{
                System.out.println("Paying Customer email not found");
            }
        }        
    }
    public void inputPayingCustomer(){
        PayingCustomer payingCustomer = new PayingCustomer();
        this.inputCustomerName(payingCustomer);
        this.inputCustomerEmail(payingCustomer);
        this.inputCustomerSupplements(payingCustomer);
        payingCustomer.setIsPayingCustomer(true);
        Scanner kb = new Scanner(System.in);
        System.out.println("Select a customer payment method");
        int selector = 0;
        while(selector!=3){
            System.out.println("1) Credit Card");
            System.out.println("2) Debit Card");
            selector = kb.nextInt();
            switch(selector){
                case 1: 
                    payingCustomer.setPaymentMethod("Credit Card");
                    System.out.println("Credit Card added");
                    selector=3;
                    break;
                case 2:
                    payingCustomer.setPaymentMethod("Debit Card");
                    System.out.println("Debit Card added");
                    selector=3;
                    break;
                default:
                    System.out.println("Invalid selection! Please try again");
            }
        }
        kb.nextLine();
        String selection = new String();
        while(!selection.equals("quit")){
            System.out.println("Enter associate account email address:");
            System.out.println("Type 'quit' to finish");
            selection = kb.nextLine();
            payingCustomer.addAssociate(selection);
            System.out.printf("Added account:%s to list of associates\n",selection);
        }
        Customer customer = (Customer)payingCustomer;
        this.customers.add(customer);
        System.out.println("Paying Customer added");
    }
    
    public void inputRemoveCustomer(){
        System.out.println("Enter the email of the account to delete:");
        Scanner kb = new Scanner(System.in);
        String email = kb.nextLine();
        this.removeCustomer(email);
    }
    public void removeCustomer(String email){
        boolean flag = false;
        for(int i =0;i<customers.size();i++){
           if(customers.get(i).getEmail().equals(email)){
               this.customers.remove(i);
               System.out.printf("The account '%s' has been removed.\n",email);
               flag = true;
           }
        }
        if(flag == false){
           System.out.printf("The user:%s does not exist! No changes were made.",email);
        }
    }
    public void inputCustomerName(Customer customer){
        System.out.println("Enter Customer Name:");
        Scanner kb = new Scanner(System.in);   
        customer.setName(kb.nextLine());
    }
    public void inputCustomerSupplements(Customer customer){
        Scanner kb = new Scanner(System.in);
        int selection = 0;
        while(selection !=6){
            System.out.println("Please select from the following supplements:");
            System.out.println("1)Sports ");
            System.out.println("2)Politics ");
            System.out.println("3)Science ");
            System.out.println("4)News ");
            System.out.println("5)Art");
            System.out.println("6)Quit");
            selection = kb.nextInt();
            switch(selection){
                case 1:
                    if(customer.getActiveSupplements().contains(supplement1)){
                        System.out.println("Sports has already been added");
                        break;
                    }else{
                        customer.addActiveSupplement(supplement1);
                        System.out.println("Sports added successfully");
                        break;
                    }
                case 2:
                    if(customer.getActiveSupplements().contains(supplement2)){
                        System.out.println("Politics has already been added");
                        break;
                    }else{
                        customer.addActiveSupplement(supplement2);
                        System.out.println("Politics added successfully");
                        break;
                    }
                case 3:
                    if(customer.getActiveSupplements().contains(supplement3)){
                        System.out.println("Science has already been added");
                        break;
                    }else{    
                        customer.addActiveSupplement(supplement3);
                        System.out.println("Science added successfully");
                    break;
                    }
                case 4:
                    if(customer.getActiveSupplements().contains(supplement4)){
                        System.out.println("News has already been added");
                        break;
                    }else{
                        customer.addActiveSupplement(supplement4);
                        System.out.println("News added successfully");
                        break;
                    }
                case 5:
                    if(customer.getActiveSupplements().contains(supplement5)){
                        System.out.println("Art has already been added");
                        break;
                    }else{
                        customer.addActiveSupplement(supplement5);
                        System.out.println("Art added successfully");
                    break;
                    }
                case 6:
                    break;
                default:
                    System.out.println("Invalid selection please select again");
                    break;
            }
        }
    }
    public void inputCustomerEmail(Customer customer){
        Scanner kb = new Scanner(System.in);
        boolean flag = true;
        while(flag=true){
            System.out.println("Enter Customer email:");
            String email = kb.nextLine();
            if(!this.isDuplicateEmail(email)){
                customer.setEmail(email);
                flag=false;
                System.out.println("Email added sucessfully");
                break;
            }else{
                System.out.println("Error: email already exists");
                System.out.println("Please enter a different email");
            }    
        }
    }
    public boolean isDuplicateEmail(String email){
        ArrayList<String> existingEmails = new ArrayList<String>();
        for(int i=0;i < this.customers.size();i++){
        existingEmails.add(customers.get(i).getEmail());
    }
        if(existingEmails.contains(email)){
            return true;
        }
        else{
            return false;
        }
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
    public void OutputAllMonthlyEmail(){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getIsPayingCustomer()){
                this.outputMonthlyEmail((PayingCustomer)customers.get(i));
            }
        }
    }
    //outputs monthly email for paying Customers
    public void outputMonthlyEmail(PayingCustomer customer){
        System.out.printf("\n\nHello %s \n",customer.getName());
        System.out.println("Your End of Month bill is now available.");
        System.out.printf("Your account:%s\n",customer.getEmail());
        this.outputMonthlyBill(customer);
        ArrayList<AssociateCustomer> associates = this.getAssociateCustomers(customer);
        for(int i=0; i<associates.size();i++){
            System.out.printf("Associate Account:%s\n",associates.get(i).getEmail());
            this.outputMonthlyBill(associates.get(i));
        }
        System.out.printf("Your total for the month is: $%s\n",this.getTotalMonthlyCharge(customer));
        System.out.printf("Your %s will be debited on at the end of the month.\n\n",customer.getPaymentMethod());
        
    }
    //returns all associates given a paying customer
    public ArrayList<AssociateCustomer> getAssociateCustomers(PayingCustomer payingCustomer){
        ArrayList<AssociateCustomer> associateCustomers = new ArrayList<AssociateCustomer>();
        for(int i=0;i<payingCustomer.getAssociates().size();i++){
            for(int j = 0;j < customers.size();j ++){
                if(payingCustomer.getAssociates().get(i).equals(customers.get(j).getEmail())){
                    associateCustomers.add((AssociateCustomer)customers.get(j));
                }
            }
            
        }
        return associateCustomers;
    }
    public double getTotalMonthlyCharge(Customer payingCustomer){
        double totalCost = 0;
        totalCost += getCustomerWeeklyCharge(payingCustomer);
        ArrayList<AssociateCustomer> associates = getAssociateCustomers((PayingCustomer)payingCustomer);
        for(int i=0;i<associates.size();i++){
            totalCost += getCustomerWeeklyCharge(associates.get(i));
        }
        return (4*totalCost);
        
    }
    
    
        
    //outputs end of month charge for a customer
    public void outputMonthlyBill(Customer customer){
        
        System.out.println("Base weekly charge: $5");
        for(int j = 0; j < customer.getActiveSupplements().size(); j++){
            System.out.println(customer.getActiveSupplements().get(j).getName() +
                    " $" + customer.getActiveSupplements().get(j).getWeeklyCost());
        }
        System.out.println("Total Weekly Charge:" + getCustomerWeeklyCharge(customer));
        System.out.println("Total Monthly Charge [4 x Weekly Charge] = " + 4*getCustomerWeeklyCharge(customer));
        
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

    
}
