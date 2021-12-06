package ibf2021.d2;

import static org.junit.Assert.*;
import org.junit.Test;

public class testBankAccount {

        bankAccount b1 = new bankAccount("test", 100);

        @Test
        public void testWithdraw(){
            float expectedVal = 50;
            b1.withdraw(50);
            assertEquals(expectedVal, b1.getAccBalance());
            System.out.println(expectedVal);
            System.out.println(b1.getAccBalance());
        }

        @Test
        public void testDeposit(){
            float expectedVal = 150;
            b1.deposit(50);
            assertEquals(expectedVal, b1.getAccBalance());
            System.out.println(expectedVal);
            System.out.println(b1.getAccBalance());
        }

    
}
