package ibf2021.d2;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.lang.Integer;


public class bankAccount {
    //Initialisation of the 7 private variables
    private String name;
    private String accNo;
    private float accBalance;
    private List<String> transactions;
    private boolean accClosed;
    private String accCreateDate;
    private String accClosedDate;

    //Getters for all 7 variables
    public String getAccClosedDate() {
        return accClosedDate;
    }
    public String getAccNo() {
        return accNo;
    }
    public float getAccBalance() {
        return accBalance;
    }
    public String getAccCreateDate() {
        return accCreateDate;
    }
    public String getName() {
        return name;
    }
    public List<String> getTransactions() {
        return transactions;
    }

    //Setters for the relevant variables excluding name and acc No.
    public void setAccClosed(boolean accClosed) {
        this.accClosed = accClosed;
    }
    public void setAccClosedDate(String accClosedDate) {
        this.accClosedDate = accClosedDate;
    }
    public void setAccCreateDate(String accCreateDate) {
        this.accCreateDate = accCreateDate;
    }
    public void setBalance(float accBalance) {
        this.accBalance = accBalance;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public void setAccountClosedDate (String accClosedDate){
        this.accClosedDate = accClosedDate;
    }
    // Told that it is not possible to set name and account number as they are read only properties

    //Constructor to set name and account number
    public bankAccount(String name){
        this.name = name;
        this.accNo = Integer.toString((int) (Math.random()*1000000000));
        this.accBalance = 0;
        transactions = new ArrayList<>();
    }

    public bankAccount(String name, float accBalance){
        this.name = name;
        this.accBalance = accBalance;
        // TODO with account balance
    }

    // Methods to be written:
    // Depositing money into bank account
    public void deposit(float depositAmt){
        // deposit must be greater than 0, else print an error statement
        this.accBalance = this.accBalance + depositAmt;
        LocalDateTime myDateTime = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        String formattedDateTime = myDateTime.format(formatDateTime);
        String transactionStatement = ("deposit $"+ depositAmt+ "at "+formattedDateTime);
        transactions.add(transactionStatement);
        System.out.printf("deposit $%d at %t", depositAmt, formattedDateTime);
    
        if (depositAmt<=0){
            System.err.println("You cannot deposit a value less than or equals to 0!");
            throw new IllegalArgumentException();
        }
        else if (accClosed == true){
            System.err.println("Your bank account has been closed!");
            throw new IllegalArgumentException();
        }
        
    }

    //Second method
    //This operation should be added to the transaction list in the following format:
    // "withdraw $100 at <date time>"
    public void withdraw(float withdrawAmt){
        try {
            this.accBalance = this.accBalance - withdrawAmt;
            LocalDateTime myDateTime = LocalDateTime.now();
            DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
            String formattedDateTime = myDateTime.format(formatDateTime);
            String transactionStatement = ("withdraw $"+ withdrawAmt+ "at "+formattedDateTime);
            transactions.add(transactionStatement);
            System.out.printf("withdraw $%d at %t", withdrawAmt, formattedDateTime);
        } catch (Exception illegalArgumentException) {
            if (withdrawAmt<=0){
                System.err.println("You cannot withdraw a value less than or equals to 0!");
                throw new IllegalArgumentException();
            }
            else if (accClosed==true){
                System.err.println("Your account is closed!");
                throw new IllegalArgumentException();
            }
        }
    }


    public static void main(String[] args) {
        bankAccount ba1 = new bankAccount("Ming", 1000);
        System.out.println("This is "+ba1.getName()+"'s bank account.");
        System.out.println("You have remaining $"+ba1.getAccBalance()+" in your account.");
        ba1.withdraw(50);
        ba1.deposit(100);
        System.out.println("You have $"+ ba1.getAccBalance()+" remaining in your account.");
        System.out.println(ba1.getTransactions());
    }

}
