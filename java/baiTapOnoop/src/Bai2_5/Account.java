package Bai2_5;

public class Account extends Customer {
    private int id;
    private Customer customer;
    private double balance;
    public Account(int id, String name, int discount) {
        super(id, name, discount);
        this.balance = 0.0;
    }
    public Account(int id, String name, int discount, int id2, Customer customer, double balance) {
        super(id, name, discount);
        this.id = id2;  
        this.customer = customer;
        this.balance = balance;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getCustomerName() {
        return customer.getName();
    }
    public Account deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        return this;  
    }
    public Account withdraw(double amount) {
        if (balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
        return this;  
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", customer=" + customer + ", balance=$" + balance + "]";
    }

    public static void main(String[] args) {
        Customer c1 = new Customer(88, "Tan Ah Teck", 10);
        Account account1 = new Account(101, "Tan Ah Teck", 10, 101, c1, 500.0);
        System.out.println(account1);  
        
        account1.deposit(200.0); 
        System.out.println(account1);  
        
        account1.withdraw(100.0); 
        System.out.println(account1);  

        account1.withdraw(700.0);  
        System.out.println(account1); 
    }
}
