package ibf2021.d2;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankAccountTest {


        @Test
        public void testGetAccBalance(){
            BankAccount b1 = new BankAccount("test", 100);
            assertTrue(b1.getAccBalance() == 100);
        }

        @Test
        public void testWithdraw(){
            BankAccount b1 = new BankAccount("test", 100);
            b1.withdraw(50);
            assertTrue(b1.getAccBalance() == 50);
        }

        @Test
        public void testDeposit(){
            BankAccount b1 = new BankAccount("test", 100);
            b1.deposit(50);
            assertTrue(b1.getAccBalance()==150);
        }

    
}
