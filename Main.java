import java.util.*;


class Main {
  public static void main(String[] args) {

    Scanner console = new Scanner(System.in);
    //Name
    System.out.print("______________________________\n     El Mercado Nocturno\n______________________________\n\n * What is your name? ");
    String customer = console.next();
    //Balance
    System.out.print("\n * How much money can you spend? ");
    int balance = console.nextInt();

    market shop = new market(customer, balance); //class

    System.out.print("\n" + shop.inventory()); //Calling inventory method
    
    //Adding items.
    System.out.print("\nHow many items would you like to add? ");
    int num = console.nextInt();
    for (int i = 0; i < num; i++){
      System.out.print("\nCart <- ");
      String product = console.next();
      System.out.println(shop.add(product));
    }
    
    System.out.println("\n" + shop.cart()); //Calling the cart.


    //Removing items.
    System.out.print("How many items would you like to remove? ");
    num = console.nextInt();
    for (int x = 0; x < num; x++){
      System.out.print("\nBasura <- ");
      String product = console.next();
      System.out.println(shop.remove(product));
    }


    //Calling the receipt.
    System.out.println("\n" + shop.cart());
    System.out.println("_______________________________________\n_______________________________________\n" + shop.checkOut()); 

  }
}