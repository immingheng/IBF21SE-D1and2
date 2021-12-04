package ibf2021;

import java.util.*;


public class bankAccount {

    private String name;
    private String accNo;
    private float accBalance;
    private List<String> transactions;
    private boolean accClosed;
    private String accCreateDate;
    private String accClosedDate;

    //Getters
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

    //Setters
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

}
