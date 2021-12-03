package ibf2021;

import java.util.*;
import java.io.*;

public class cart {

    // Declaring variables
    private String prompt = ""; // prompt refers to user input read from console
    private List<String> cartItem = new ArrayList<String>();    //create an array list for the cart
    private String[] promptList = new String[0]; // promptList is an array of strings filled by splitting delimiter ","
    private Console con = System.console(); // console instantiation

    // prompt user what they want to do, if they entered nothing
    // calls for the possible commands to indicate what can be done
    public void promptInput() {
        this.prompt = con.readLine(">");
        this.prompt = this.prompt.trim().toLowerCase();
        if (this.prompt.isEmpty()){
            System.out.println("Please indicate what would you like me to do:");
            possibleCommands();
        }
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
    
    // this is used when user wishes to add items to the cart
    // split the prompt into promptList as an array with delimiter "," 
    public void checkPrompt() {
        prompt = con.readLine(">");
        promptList = prompt.trim().toLowerCase().split("[, ]+",0);
        //line was added to check how split works.
        //System.out.println(Arrays.toString(promptList));
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
    public cart(){}
    /*public cart(List<String> cartItem, String prompt, String[] promptList){
        this.promptList = promptList;
        this.cartItem = cartItem;
        this.prompt = prompt;
    }*/
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
        if (ID<cartItem.size()){
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
       

    public static void main(String[] args) {
        cart sc = new cart();
        System.out.println("Welcome to your shopping cart!");

        while(true){
            sc.promptInput();
            if (sc.prompt.startsWith("list")){
                sc.showCart();
            } // this is not working...
            else if (sc.prompt.startsWith("add")){
                sc.checkPrompt();
                for (int i = 1; i< sc.promptList.length; i++){
                    sc.addItem(sc.promptList[i]);
                }
            }
            else if (sc.prompt.startsWith("remove")){
                sc.checkPrompt();
                if (sc.prompt.length()==6){
                    System.out.println("Remove which index?");
                }
                else{
                    sc.removeItem(Integer.parseInt(sc.promptList[1]));
                }
            } // this works
            else if (sc.prompt.startsWith("exit")){
                break;
            }
            // this works
            else{
                System.err.println("You have entered an invalid input!");;
            }
            sc.promptInput();
            sc.checkPrompt();
        }

    }
}
