package ibf2021.d3;

import java.util.*;
import java.io.*;

public class Cart {

    // Declaring private variables - only accessible within same packages.
    private String prompt = ""; // prompt refers to user input read from console
    private List<String> cartItem = new ArrayList<String>();    //create an array list for the cart
    private String[] promptList = new String[0]; // promptList is an array of strings filled by splitting delimiter ","
    Console con = System.console(); // console instantiation

    // prompt user what they want to do, if they entered nothing
    // calls for the possible commands to indicate what can be done
    // 
    public void promptInput() {
        prompt = con.readLine(">");
        prompt = prompt.trim().toLowerCase();
        if (prompt.isEmpty()){
            System.out.println("Please indicate what would you like me to do:");
            possibleCommands();
            prompt = con.readLine(">");
        }
        // creates a list of array of the user input word by word
        promptList = prompt.split("[, ]+",0);
    }

    // this list out the possible commands the user can do
    public void possibleCommands() {
        List<String> commands = new ArrayList<>();
        commands.add(0, "list");
        commands.add(1, "add");
        commands.add(2, "remove");
        commands.add(3, "exit");
        for (int j = 0; j< commands.size(); j++){
            System.out.printf("%d. %s\n",j+1, commands.get(j));
        }
    }
    

    public void showCart() {
        if (cartItem.size()==0){
            System.err.println("Your cart is empty!");
        }
        else{
            for (int i = 0 ; i < cartItem.size(); i++){
                System.out.printf("%d. %s\n", i+1, cartItem.get(i));
            }
        }
    }

    //Constructor
   public Cart(){}
    public Cart(List<String> cartItem, String prompt, String[] promptList){
        this.promptList = promptList;
        this.cartItem = cartItem;
        this.prompt = prompt;
    }

    // check if item exists in cart already, if it hasn't add it in
    // else indicate to user that the item already exists in cart
    public void addItem(String item) {
        if (!cartItem.contains(item)){
            System.out.printf("%s has been added to your cart!\n", item);
            cartItem.add(item);
        } 
        else {
            System.err.printf("%s is already in your cart!\n", item);
        }
        
    }

    public void removeItem(int ID) {
        try{
            if (ID<=cartItem.size()){
                System.out.printf("%s has been removed from your cart\n", cartItem.get(ID-1));
                cartItem.remove(ID-1);
            }
            else if (cartItem.size()==0){
                System.err.println("There is nothing in your cart to remove!");
            }
            else {
                System.err.println("Incorrect item index!");
            }
        }
        catch (NumberFormatException ex){
            System.err.println("Index must be an integer!");
        }
    } 
       

    public static void main(String[] args) {
        // instantiate an instance of cart 
        Cart sc = new Cart();
        System.out.println("Welcome to your shopping cart!");

        while(true){
            sc.promptInput();
            if (sc.prompt.startsWith("list")){
                sc.showCart();
            } // this is not working...
            else if (sc.prompt.startsWith("add")){
                for (int i = 1; i< sc.promptList.length; i++){
                    sc.addItem(sc.promptList[i]);
                }
            }
            else if (sc.prompt.startsWith("remove")){
                if (sc.prompt.length()==6){
                    System.out.println("Remove which index?");
                }
                else{
                    sc.removeItem(Integer.parseInt(sc.promptList[1]));
                }
            } 
            else if (sc.prompt.startsWith("exit")){
                System.out.println("Goodbye!");
                break;
            }
            else{
                System.err.println("You have entered an invalid input!");
            }
        } // end while loop
    } // end main


}
