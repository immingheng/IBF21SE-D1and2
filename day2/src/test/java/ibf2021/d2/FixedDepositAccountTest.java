package ibf2021.d2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FixedDepositAccountTest {

    

    @Test
    public void testWithdraw(){
        FixedDepositAccount fdnew = new FixedDepositAccount("Ming", 1000f, 5f, 10);
        fdnew.withdraw(100);
        assertTrue("NOP withdrawal",fdnew.getAccBalance()==1000f);
    }

    @Test
    public void testDeposit(){
        FixedDepositAccount fdnew1 = new FixedDepositAccount("Heng", 1000f, 10f, 20);
        fdnew1.deposit(100);
        assertTrue("NOP deposit", fdnew1.getAccBalance()==1000f);
    }

    @Test
    public void testSetInterest(){
        FixedDepositAccount fdnew = new FixedDepositAccount("MH", 1000f, 20f, 6);
        fdnew.setInterest(5f);
        assertTrue("Assign new interest to be 5", fdnew.getBalance()==1005f);
    }

    @Test
    public void testSetDuration(){
        FixedDepositAccount fdnew = new FixedDepositAccount("M", 1000f, 10f);
        fdnew.setDuration(10);
        assertTrue("Check if isDurationChange == true", fdnew.isDurationChanged==true);
    
    }

    

    
}
