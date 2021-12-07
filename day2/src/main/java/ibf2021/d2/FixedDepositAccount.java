package ibf2021.d2;

import java.io.Console;

public class FixedDepositAccount extends BankAccount {

    // Told that default interest and duration = 3 and 6 respectively
    private float interest = (float) 3.0;
    private int durationInMonths = 6;
    private boolean isInterestChanged = false;
    boolean isDurationChanged = false;
    Console cons = System.console();

    //Constructors
    public FixedDepositAccount(String name, Float balance) {
        super(name, balance);
    }

    public FixedDepositAccount(String name, Float balance, Float interest){
        super(name, balance);
        this.interest = interest;
    }

    public FixedDepositAccount(String name, Float balance, Float interest, Integer durationInMonths){
        super(name, balance);
        this.interest = interest;
        this.durationInMonths = durationInMonths;
    }

    //Told that interest and duration can be changed once, any subsequent attempt
    // will result in an IllegalArgumentException
    public void setInterest(float interest){
        if (isInterestChanged==true){
            throw new IllegalArgumentException();
        }
        this.interest = interest;
        isInterestChanged = true;
    }

    public void setDuration (int durationInMonths){
        if (isDurationChanged==true){
            throw new IllegalArgumentException();
        }

        this.durationInMonths = durationInMonths;
        isDurationChanged = true;
    }


    @Override
    public void withdraw(float withdrawAmt){
        // Override bank account's withdraw and deposit methods to do nothing
    }

    @Override
    public void deposit(float depositAmt){
    }

    public float getBalance(){
        setBalance(this.getAccBalance()+interest);
        return this.getAccBalance();
    }

    public static void main(String[] args) {
        FixedDepositAccount fd1 = new FixedDepositAccount("Ming", 1000f, 3f, 6);
        fd1.setInterest(5);
        fd1.withdraw(100);
        fd1.deposit(50);
        //fd1.setInterest(10);
        System.out.println("You got "+fd1.getBalance()+" in your fixed deposit account.");
    }

}
    
