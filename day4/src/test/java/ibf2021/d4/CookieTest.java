package ibf2021.d4;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class CookieTest {

    @Test
    public void testCookie() throws FileNotFoundException, IOException{
        assertTrue("Test if Cookie array has the random cookie generated",Cookie.Cookies.contains(Cookie.getCookie())==true);
    }
    
}
