
// 5. Each customer of a bank has customer id, name, and current loan amount and phone number. One 
// can change the attributes like name, phone number. A customer may ask for loan of certain amount. 
// It is granted provided the sum of current loan amount and asked amount does not exceed credit limit 
// (fixed amount for all customer). A customer can be a privileged customer. For such customers credit 
// limit is higher. Once a loan is sanctioned necessary updates should be made. Any type of customer 
// should be able to find his credit limit, current loan amount and amount of loan (s)he can seek.  No 
// customer can change customer id once created. Print customer name when the object is printed by 
// toString() method. Design and implement the classes. Show the working through a menu driven user interface.

import java.util.Scanner;
import java.util.HashMap;

abstract class Customer {
    private final String customerId;  // Cannot be changed once created
    private String name;
    private String phoneNumber;
    private float currentLoanAmount;
    private static final float NORMAL_CREDIT_LIMIT = 50000;
    private static final float PRIVILEGED_CREDIT_LIMIT = 100000;

    Customer(String customerId, String name, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currentLoanAmount = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public float getCurrentLoanAmount() {
        return currentLoanAmount;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name updated successfully.");
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        System.out.println("Phone number updated successfully.");
    }

    // Abstract method for credit limit
    abstract float getCreditLimit();

    // Calculate remaining loan available
    public float getRemainingLoanAvailable() {
        return getCreditLimit() - currentLoanAmount;
    }

    // Request loan
    public boolean requestLoan(float loanAmount) {
        if (loanAmount <= 0) {
            System.out.println("Loan amount must be positive.");
            return false;
        }

        if (currentLoanAmount + loanAmount > getCreditLimit()) {
            System.out.println("Loan request denied. Exceeds credit limit.");
            System.out.println("Current loan: " + currentLoanAmount + 
                             " | Requested: " + loanAmount + 
                             " | Credit limit: " + getCreditLimit());
            return false;
        }

        currentLoanAmount += loanAmount;
        System.out.println("Loan of " + loanAmount + " has been sanctioned.");
        return true;
    }

    // Display customer details
    public void displayDetails() {
        System.out.println("\n----- Customer Details -----");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Current Loan Amount: " + currentLoanAmount);
        System.out.println("Credit Limit: " + getCreditLimit());
        System.out.println("Remaining Loan Available: " + getRemainingLoanAvailable());
        System.out.println("------------------------------");
    }

    @Override
    public String toString() {
        return name;
    }
}

class RegularCustomer extends Customer {
    RegularCustomer(String customerId, String name, String phoneNumber) {
        super(customerId, name, phoneNumber);
    }

    @Override
    float getCreditLimit() {
        return 50000;
    }
}

class PrivilegedCustomer extends Customer {
    PrivilegedCustomer(String customerId, String name, String phoneNumber) {
        super(customerId, name, phoneNumber);
    }

    @Override
    float getCreditLimit() {
        return 100000;
    }
}

public class Bank {
    private HashMap<String, Customer> customers;

    Bank() {
        customers = new HashMap<>();
    }

    // Add new customer
    public void addCustomer(String customerId, String name, String phoneNumber, boolean isPrivileged) {
        if (customers.containsKey(customerId)) {
            System.out.println("Customer ID already exists.");
            return;
        }

        Customer customer;
        if (isPrivileged) {
            customer = new PrivilegedCustomer(customerId, name, phoneNumber);
        } else {
            customer = new RegularCustomer(customerId, name, phoneNumber);
        }
        customers.put(customerId, customer);
        System.out.println("Customer added successfully.");
    }

    // Find customer
    public Customer findCustomer(String customerId) {
        if (!customers.containsKey(customerId)) {
            System.out.println("Customer not found.");
            return null;
        }
        return customers.get(customerId);
    }

    // Update customer name
    public void updateName(String customerId, String newName) {
        Customer customer = findCustomer(customerId);
        if (customer != null) {
            customer.setName(newName);
        }
    }

    // Update customer phone
    public void updatePhoneNumber(String customerId, String newPhone) {
        Customer customer = findCustomer(customerId);
        if (customer != null) {
            customer.setPhoneNumber(newPhone);
        }
    }

    // Request loan
    public void requestLoan(String customerId, float loanAmount) {
        Customer customer = findCustomer(customerId);
        if (customer != null) {
            customer.requestLoan(loanAmount);
        }
    }

    // Display all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers.values()) {
            customer.displayDetails();
        }
    }

    // Display customer info
    public void displayCustomerInfo(String customerId) {
        Customer customer = findCustomer(customerId);
        if (customer != null) {
            customer.displayDetails();
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Bank Customer Management System =====\n");
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n----- Menu -----");
            System.out.println("1. Add Customer");
            System.out.println("2. View Customer Details");
            System.out.println("3. Update Customer Name");
            System.out.println("4. Update Phone Number");
            System.out.println("5. Request Loan");
            System.out.println("6. Display All Customers");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String custId = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.nextLine();
                    System.out.print("Is Privileged Customer? (y/n): ");
                    boolean isPrivileged = sc.nextLine().equalsIgnoreCase("y");
                    bank.addCustomer(custId, name, phone, isPrivileged);
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    String searchId = sc.nextLine();
                    bank.displayCustomerInfo(searchId);
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    String updateCustId = sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    bank.updateName(updateCustId, newName);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    String phoneUpdateId = sc.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();
                    bank.updatePhoneNumber(phoneUpdateId, newPhone);
                    break;

                case 5:
                    System.out.print("Enter Customer ID: ");
                    String loanCustId = sc.nextLine();
                    System.out.print("Enter Loan Amount: ");
                    float loanAmount = sc.nextFloat();
                    sc.nextLine(); // Consume newline
                    bank.requestLoan(loanCustId, loanAmount);
                    break;

                case 6:
                    bank.displayAllCustomers();
                    break;

                case 7:
                    System.out.println("Thank you for using Bank Customer Management System. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        sc.close();
    }
}