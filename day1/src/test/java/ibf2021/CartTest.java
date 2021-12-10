package ibf2021;

import static org.junit.Assert.assertTrue;

/* import org.junit.After;
import org.junit.Before; */
import org.junit.Test;

public class CartTest {
 
    /* private Cart cart;

    @Before
    public void initialisation() {
        cart = new Cart();
    }

    @After
    public void clean(){
        cart = null;
    }
 */
    

    @Test
    public void testAddItem() {
        Cart c1 = new Cart(); // Instantiate cart
        c1.addItem("potato");
        boolean testcheck = c1.cartItem.contains("potato");
        if (testcheck == true) 
            System.out.println("Method addItem works!");
        else
            System.out.println("Method addItem failed!");
        assertTrue("Check if cart has potato in it", (testcheck = true));
    }

    @Test
    public void testItemInCart() {
        Cart c2 = new Cart();
        c2.addItem("pineapple");
        boolean testcheck = c2.cartItem.contains("pineapple");
        if (testcheck){
            System.out.println("Pineapple is in cart indeed");
            assertTrue("Check if pineapple is in cart", testcheck=true);
        }
        else
            System.out.println("Item is not in cart, how odd...");
    }

    @Test
    public void testSizeOfCart() {
        Cart c3 = new Cart();
        c3.addItem("Potato");
        c3.addItem("Apple");
        c3.addItem("Orange");
        boolean checktest = (c3.cartItem.size() == 3);
        if (checktest){
            System.out.println("Cart indeed has 3 items");
            assertTrue("Check if cart has 3 items after adding 3 items", checktest);
        }
        else
            System.out.println("Opps! Something went wrong in your cart size check");
    }

    @Test
    public void testRemoveItem(){
        Cart c4 = new Cart();
        c4.addItem("potato");
        c4.addItem("french-fries");
        c4.removeItem(2);
        boolean checktest = (c4.cartItem.size()==1);
        if (checktest){
            System.out.println("removeItem method worked!");
            assertTrue("Check if removeItem works",checktest);
        }
        else{
            System.err.println("Removal of item failed!");
        }
    }


}
