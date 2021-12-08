package ibf2021.d3;

import java.io.*;
import java.util.*;

public class ShoppingCartDB extends Cart{

    // declare variables
    String line;
    boolean isLoggedIn = false;
    public String username;

    // create default database directory
    String defaultPath = "day3/src/main/java/ibf2021/d3/db" ;
    String path = defaultPath; 
    File file = new File(path); 
    boolean makeDB = file.mkdir();
    List<String> fromFile = new ArrayList<>();
    List<String> writeFile = new ArrayList<>();


    
    // Task 1 is to allow user to specify a directory to store user's cart
    // such that java shoppingcart.jar car tdb can be used
    // and cartdb is the database directory.
    // If program is started without specification:
    // Program by default use directory call db.
    public void FileDirectory(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to specify a new directory? (Y/N)");
        String reply = sc.next();
        if (reply.toLowerCase().equals("y")) {
            System.out.println("Enter the path to create the folder in");
            path = sc.next();
            System.out.println("Enter the name of the desired folder: ");
            path = path+"\\"+sc.next();
            file = new File(path);
            boolean makeDB = file.mkdir();
            if(makeDB == true){
                System.out.println("Folder has been created successfully!");
            }
            else{
                //check if file already exists
                if (file.exists()){
                    System.out.println("The folder already exists in the path prescribed.");
                    System.out.println("The default folder db will be used!");
                    path = defaultPath;
            
                }
                else{
                    System.err.println("Error is found!");
                    System.out.println("The default folder db will be used!");
                    path = defaultPath;
            
                }
            }
        } else if (reply.toLowerCase().equals("n")) {
            System.out.println("The default folder db will be used.");
    
        }
        else {
            System.err.println("You have entered an invalid input!");
            System.out.println("The default folder db will be used!");
            path = defaultPath;
        }
        
    }

    public void Login() throws IOException{
        // method takes loginID as argument
        // link the loginID to its respective db
        String LoginID = username;
        String dbFile = path+"/"+LoginID+".db";
        File user = new File(dbFile);     
        isLoggedIn = true;   
        cartItem.clear();
        // check if there's existing db for the user, if so, delete this instance
        if (user.exists()){
            System.out.printf("Welcome back %s!\n",LoginID);
            // when there is an existing db for the user, read whatever is in the file to the cart Item array
            try (Reader reader = new FileReader(dbFile)) {
                BufferedReader br = new BufferedReader(reader);
                if (null == (line=br.readLine())) {
                    System.out.println("You have an empty cart.");
                } else {
                    System.out.println("Your cart currently contains the following items: ");
                    System.out.println(line);
                    cartItem.add(line);
                    // while there is still line to read in the file
                    while (null != (line=br.readLine())){
                        System.out.println(line);
                        cartItem.add(line);
                    }
                }

            }
        }
        else { // for new user(s), create new .db file
        //System.out.printf("Welcome new user: %s!\n",LoginID);
        // if user does not exists, create new .db file for the LoginID   
        OutputStream os = new FileOutputStream(dbFile);
        os.close();
        }
        
    }

    //Save the content of the cart to the user's SC file
    // e.g. save to db/user.db
    /*
    If one tries to save without logging in, print reminder msg to login first. 
    */
    public void Save() throws IOException{
        String fileName = path+"/"+username+".db";
        File f = new File(fileName);
        // delete old version of the .db file and create new one with existing items in cart.
        f.delete();
        System.out.println("Your cart has been saved!");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
            for (String item : cartItem){
                writer.write(item);
                writer.newLine();

            }
        }

        if (isLoggedIn==false){
            System.out.println("Please note that you have yet to login!");
            System.out.println("Your cart has been saved in null.db");
        }
    }

    // This method should lists all users
    // Listing all filenames under directory
    public void ListUsers(){
        
        //path is a string and create a file instance
        File folder = new File(path);
        // listfiles creates an array of files which can be used for loop
        File[] fileArray = folder.listFiles(); 
         /* for (File f: fileArray){
            // obtain file name as string and using String methods to search for .db extensions 
            String fullFileName = f.getName();
            List<String> u = new ArrayList<>();
            int endIndex = fullFileName.lastIndexOf(".db");
            int startIndex = 0;
            u.add(fullFileName.substring(startIndex, endIndex));
            System.out.println(u.toString());  
            //System.out.println(f.getName());
        } */
        if (fileArray.length==0){
            System.out.println("There are no existing users in your database folder!");
        }
        for (int i = 0; i<fileArray.length; i++) {
            String fileName = fileArray[i].toString();
            int endIndex = fileName.lastIndexOf(".db");
            if (endIndex==-1){
                continue;
            }
            int startIndex = fileName.indexOf("\\db\\")+4;
            String userFiles = fileName.substring(startIndex, endIndex);
            System.out.println(i+1+". "+userFiles);
        }
        

        

    }

    public static void main(String[] args) {
        ShoppingCartDB scdb = new ShoppingCartDB();
        System.out.println("Welcome to your shopping cart!");
        scdb.FileDirectory();
        while(true){
            scdb.promptInput();
            if (scdb.prompt.startsWith("list")){
                scdb.showCart();
            } 
            else if (scdb.prompt.startsWith("add")){
                for (int i = 1; i< scdb.promptList.length; i++){
                    scdb.addItem(scdb.promptList[i]);
                }
            }
            else if (scdb.prompt.startsWith("remove")){
                if (scdb.prompt.length()==6){
                    System.out.println("Remove which index?");
                }
                else{
                    scdb.removeItem(Integer.parseInt(scdb.promptList[1]));
                }
            } 
            else if (scdb.prompt.startsWith("login")){
                scdb.username = scdb.promptList[1];
                try {
                    scdb.Login();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (scdb.prompt.startsWith("users")){
                scdb.ListUsers();
            }
            else if (scdb.prompt.startsWith("save")){
                try {
                    scdb.Save();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (scdb.prompt.startsWith("exit")){
                System.out.println("Goodbye!");
                break;
            }
            else{
                System.err.println("You have entered an invalid input!");
            }
        } // end while loop
    
    }
    
}
