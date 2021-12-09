package ibf2021.day6;

import java.io.*;
import java.util.*;

/*
Separate class to manage the cookie file.
All interactions with cookie should go through an instance of this class
Example includes opening and closing cookie file and randomly return a cookie text
*/

public class Cookie {

    public static String line;
    public static List<String> Cookies = new ArrayList<>();
    public String msg;

    public static String getCookie() throws FileNotFoundException, IOException{
        String cookietxt = "C:\\Users\\immin\\Desktop\\TFIP-IBF\\Software-Engineering-Fundamentals\\Codes\\GITHUB\\Workshops\\IBFSE21\\day4\\src\\main\\java\\ibf2021\\d4\\cookie_file.txt";
        try (Reader reader = new FileReader(cookietxt)) {
            BufferedReader br = new BufferedReader(reader);
            while (null!= (line = br.readLine())){
                Cookies.add(line);
            }
            // Upon reading the entire cookiefile, array Cookies now consist of all the possible cookies that exists
            // Random index generator - floor because size is always 1 greater than valid index!
            int index = (int) Math.floor(Math.random()*Cookies.size());
            return Cookies.get(index);
        }
    }
    
}
