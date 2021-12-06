/* 
    Workshop 1:
    Writes a java console program that allows user to:
        1. add item(s) to cart,
        2. remove item(s) to cart &
        3. list content in cart.
*/
package ibf2021;

import java.util.*;
import java.io.*;

public class cartStringsMethod {
    
    public static void main(String[] args) {
       // list is an interface while arraylist is a class.
        List<String> cart = new ArrayList<String>();
        // initialise system console and import appropriate packages/classes
        Console con = System.console();
        // initialise empty string to prompt to speed up the code
        String prompt;
        // Print welcome message
        System.out.println("Welcome to your shopping cart");
        prompt = con.readLine(">");
        prompt = prompt.trim().toLowerCase();

        while(true){
            
            // if prompt holds an empty string, prompt the user what he can do
            while (prompt.isEmpty()){
                System.out.println("Please indicate to me what would you like to do:");
                System.out.println("List the cart");
                System.out.println("Add item");
                System.out.println("Remove item");
                System.out.println("Exit the program");
                prompt = con.readLine(">");
            }
            
            // if user request to list cart, check if there is any item in the cart and print accordingly
            if (prompt.startsWith("list")) {
                if (cart.size()!=0){
                    for (int i =0; i<cart.size(); i++)
                        // index shown on screen should be one greater than valid index
                        System.out.printf("%d. %s\n", i+1, cart.get(i));
                }
                else {
                    System.out.println("Your cart is empty.");
                }
            }
            else if (prompt.startsWith("add")){
                // add the words behind the add input
                // check if there are multiple inputs
                String result = "";
                if (prompt.length()==3){
                    System.out.println("You didn't tell me what to add!");
                }
                else if (prompt.contains(" ")){
                    // the first item will always come after the space in between the add and the item.
                    int startIndex = prompt.indexOf(" ") + 1;
                    // check for multiple inputs by looping through every single character within the given String
                   // for (String word : prompt)
                    if (prompt.contains(",")){
                        String temp = prompt;
                        int endIndex;
                            
                        // check for "," and replace temp to be whatever remaining
                        while (temp.contains(",")){
                            // search for comma and set the endIndex to be at it
                            endIndex = temp.indexOf(",",startIndex); // find first instance of , and set its position to be the end index
                            result = temp.substring(startIndex, endIndex);
                            result = result.trim();
                            // check for duplicates
                            if (cart.contains(result)){
                                System.err.printf("%s is already in your cart!\n", result);
                            }
                            else{ 
                                System.out.printf("%s has been added to your cart.\n",result);
                                cart.add(result); //add first item to cart
                                
                            }
                            // now initialise startIndex to start from endIndex +1
                            startIndex = endIndex+1;
                            // re-initialise temp to remaining string then go to next iteration until temp doesnt contain ,
                            temp = temp.substring(startIndex);
                            //System.out.println(temp);
                            // the length of temp will then be shortened hence all startIndex and endIndex have to be reinitialised
                            startIndex = 0;
                            continue;
                            } // end of inner while
                            // this should print the last item within the single input
                        result = temp.substring(startIndex);
                        result = result.trim();
                        if (cart.contains(result)){
                            System.err.printf("%s is already in your cart!\n", result);
                        }
                        else{ 
                            System.out.printf("%s has been added to your cart.\n", result);
                            cart.add(result);
                        }
                    } // end of multiple input check if "," exists in prompt
                    else {
                        // if there is no comma, simply add the word behind add hence no need to declare endIndex
                        result = prompt.substring(startIndex);
                        if (cart.contains(result)){
                            System.out.printf("%s is already inside your cart!\n", result);
                        }
                        else{ 
                            cart.add(result);
                            System.out.printf("%s has been added to your cart.\n", result);
                        }
                    }                   
                } 
                else{
                    System.err.println("Add a space after add!");//end of else if statement on whether space exists in prompt
                }
            } // end of "add" 
            else if (prompt.startsWith("remove")){
                if (prompt.length()==6){
                    System.out.println("Remove which index?");
                }
                // user input after remove must be an integer to indicate which item index to be removed from the cart.
                
                else {
                    try {
                    String index = prompt.substring(prompt.indexOf(" ")+1);
                    int ID = Integer.parseInt(index);
                    //check if ID is within the bound of valid index of the arrayList
                        if (ID<=cart.size()){
                            System.out.printf("%s has been removed from your cart.\n", cart.get(ID-1)); 
                            cart.remove(ID-1);
                        }
                        else if (cart.size()==0){
                            System.err.println("There is nothing in your cart to remove!");
                        }
                        else{
                            System.err.println("Incorrect item index!");
                        }
                    }
                    catch (NumberFormatException ex){
                    System.err.println("Index must be an integer!");
                    }
                }


                
            }
            // to terminate the while (true) loop
            else if (prompt.startsWith("exit")){
                System.out.println("Goodbye!");
                break;
            }
            // any other input will return an invalid input 
            else {
                System.out.println("You have entered an invalid input!");
            }
        

        prompt = con.readLine(">");
        prompt = prompt.trim().toLowerCase();
        } // exit big while true loop
        
    } // end of main method


} // end of class method
