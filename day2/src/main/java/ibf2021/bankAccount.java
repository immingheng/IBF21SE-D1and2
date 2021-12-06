package ibf2021;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


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
    // Told that it is not possible to set name and account number as they are read only properties

    //Constructor to set name and account number
    public bankAccount(String name){
        this.name = name;
        this.accBalance = 0f; //0f indicates floating point number
        this.accNo = "";
    }

    public bankAccount(String name, float accBalance){
        this.name = name;
        // TODO with account balance
    }

    // Methods to be written:
    public int deposit(){
        //This operation should be added to the transaction list in the
        // following format: "deposit $100 at <date time>"
        
        LocalDateTime myDateTime = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
        String formattedDateTime = myDateTime.format(formatDateTime);
        //System.out.println(formattedDateTime);

        System.out.printf("deposit $%d at %t", deposit(), formattedDateTime);
        return deposit();

    }

    public static void main(String[] args) {
        
    }

}
