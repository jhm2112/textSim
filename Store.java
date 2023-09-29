import java.util.Scanner;
import java.util.Vector;

/*
 * The store class contains a list of products and other
 * useful methods to initialize, modify and obtain info
 * from the class.
 */

public class Store {
    private Vector<Pair> products = new Vector<Pair>();

    public Store(Vector<Pair> products) {
        this.products.addAll(products);
    }

    public void addProduct(Pair p) {
        this.products.add(p);
    }

    public Vector<Pair> getProducts() {
        return this.products;
    }

    public int getPrice(int index) {
        return this.products.get(index).getPrice();
    }

    public String getName(int index) {
        return this.products.get(index).getName();
    }

    public void printStore() {
        for(int i = 1; i <= products.size(); i++) {
            System.out.println(i + ". " + products.get(i-1).getName() + " $" + products.get(i).getPrice() );
        }
    }

    /* 
     * This methods allow an interactive user experience for the store. It allows the user to
     * see the list of products and purchase them if they have the credits for it
     */
    public void visitStore(Player p) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to the automated store terminal. Your total credits are: " + p.numberOfCredits()
        + " \n Input the product number to purchase or a number < 0 to exit"
        + " Here is the list of products:");
        
        this.printStore();

        int choice = input.nextInt();
        while(choice >= 0) {
            // Catching wrong inputs
            while ( choice > products.size() || choice == 0) {
                System.out.println("That's not an option!. Try again: ");
                choice = input.nextInt();
            }   
            // terminate the execution of the store
            if(choice < 0) {break;}

            int price = this.getPrice(choice - 1);
            
            // checking if user has the credits to purchase
            if (price > p.numberOfCredits()) {
                System.out.println("Sorry, you can't afford that");
            }
            else {
                System.out.println("Purchase complete");
                p.addToInventory(this.getName(choice - 1));
                p.addCredits(-price);
            }
            System.out.println("Need anything else?");

        }
        System.out.println("Thank you for shopping here!");
        input.close();
    }


}
