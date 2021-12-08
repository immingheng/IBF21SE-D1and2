package ibf2021.d4;

import java.io.*;
import java.util.*;

/*
Separate class to manage the cookie file.
All interactions with cookie should go through an instance of this class
Example includes opening and closing cookie file and randomly return a cookie text
*/

public class Cookie {

    static String line;
    static List<String> Cookies = new ArrayList<>();
    static String msg;

    public static String getCookie() throws FileNotFoundException, IOException{
        try (Reader reader = new FileReader("C:\\Users\\immin\\Desktop\\TFIP-IBF\\Software-Engineering-Fundamentals\\Codes\\GITHUB\\Workshops\\IBFSE21\\day4\\src\\main\\java\\ibf2021\\d4\\cookie_file.txt")) {
            BufferedReader br = new BufferedReader(reader);
            while (null!= (line = br.readLine())){
                Cookies.add(line);
            }
            // Upon reading the entire cookiefile, array Cookies now consist of all the possible cookies that exists
            // Random index generator
            int index = (int) Math.floor(Math.random()*Cookies.size());
            return Cookies.get(index);
        }
    }

    public void close(){

    }

    
}
