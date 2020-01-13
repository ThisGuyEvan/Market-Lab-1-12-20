import java.util.*;

public class market{

  //Intializing the private variables utilized within this class.
  private String customer;
  private double bal;
  private ArrayList<String> cart = new ArrayList<String>();
  private String[][] inventory = {{"Cucumber", "Tomato", "Lettuce", "Squash", "Cheese"}, {"1.00", "2.00", "1.50", "3.20", "5.00"}};

  //Constructor
  market(String customer, int bal){
    this.customer = customer;
    this.bal = bal;
  }

  public String inventory(){
    String items = "----------------------------\nInventory\n----------------------------\n";
    for (int i = 0; i < inventory[0].length; i++){
      items += "Item: " + inventory[0][i] + " - Price: $" + inventory[1][i] + "\n";
    }
    
    return items;
  }

  //Displays the user's current 'cart' of items.
  public String cart(){
    String items = "";

    //tests whether there are any items to avoid errors.
    if (cart.size() == 0){
      items = "There are currently no items in your cart.";
    }
    else{

      //Builds a string to return.
      for (int i = 0; i < cart.size()-1; i++){
        items += "[" + (i+1) + "]: " + cart.get(i) + ".\n";
      }
      items += "[" + cart.size() + "]: " + cart.get(cart.size()-1) + ".";
    }


    return items;
  }
  
  public String add(String product){
    //Checking if the item the user prompts is within the inventory, if so add.
    for (int i = 0; i < inventory[0].length; i++){
      if (product.equalsIgnoreCase(inventory[0][i])){
        cart.add(inventory[0][i]);
        return ("Successfully the item into " + customer + "'s cart!");
        
      }
    } 
    return ("The item that you are currently adding to your cart is not currently available!");

  }

  public String remove(String product){
    //Checking if the item the user prompts is within the cart, if so remove.
    for (int i = 0; i < cart.size(); i++){
      if (product.equalsIgnoreCase(cart.get(i))){
        cart.remove(cart.get(i));
        return ("Successfully remove the item from " + customer + "'s cart!'");

      }
    }
    return ("The item that you are currently removing from your cart does not exist!");
  }

  public String checkOut(){

    //Intializing variables.
    int barCode = 0;
    double total = 0;
    String items = "";
    boolean debt = false;

    //Finding the items that were purchased and linking to the price, 2D arrays.
    for (int i = 0; i < cart.size(); i++){
      for (int x = 0; x < inventory[1].length; x++){
        if (cart.get(i).equalsIgnoreCase(inventory[0][x])){
          barCode = x;
          items += "[" + inventory[0][x] + "] - $" + inventory[1][x] + "\n"; 
          break;
        }
      }
      total += Double.parseDouble(inventory[1][barCode]);
      
    }

    //Finalizing prices and returns.
    double salesTotal = total * 1.08875;
    this.bal -= salesTotal;

    if (this.bal < 0){
      debt = true;
    }

    return ("\n------------------\nReceipt\n------------------\n" + items + "      -=+=-\nCheckout: $" + total + "\nSales tax: 8.875%\nTotal: $" + salesTotal + "\nRemaining balance: " + bal + "\nIn Debt? " + debt + "\n------------------\n" + "\n\n There may be EXTREMELY long decimals...");
  }

}
