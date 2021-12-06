package ibf2021.d2;

public class fixedDeposit extends bankAccount {

    public fixedDeposit(String name) {
        super(name);
        //TODO Auto-generated constructor stub
    }
    public static void main(String[] args) {
        
    }
}
/*
    public static void main(String[] args) {
         //Fixed Deposit Class
    // has additional members, methods and constructors
    public void FixedDepositAccount(){
        float interest = 3f;
        int durationInMonths = 6;
        int count = 0;
    // the default interest and duration is 3 and 6 respectively
    // They can only be changed once and any subsequent attempt will result in 
    // IllegalArgumentException thrown
    // Once balance is set, it cannot be changed.
    
        try {
            
            System.out.println("Input new interest in floating point number: ");
            interest = Integer.parseInt(cons.readLine());
            System.out.println("Input new duration in months for fixed deposit account(integer only): ");
            durationInMonths = Integer.parseInt(cons.readLine());
            count = count +1; 
        } catch (Exception illegalArgumentException) {
            if (count<=1){
                System.err.println("You can only change your fixed deposit account interest and duration once!");
            }
        
        }

        //Making withdraw and deposit methods not updating the account balance
        @Override
        withdraw().withdrawAmt = 0;
        deposit().depositAmt = 0;

    }
    
}
*/