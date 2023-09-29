import java.util.Vector;

/*
 * Player class works as a container for useful variables that describe the
 * current progress and status of the player. It contains methods to modify
 * and get the values of the variables
 */
public class Player {

    private int credits;
    private String house;
    private String name;
    private String job;
    private int salary;
    private int rent;
    private int gifts;
    private boolean worked;
    private Vector<String> inventory = new Vector<String>();

    public Player (String name) {
        this.name = name;
        this.credits = 500;
        this.house = "Functional Unit #2112";
        this.job = "Cubicle Dweller";
        this.salary = 500;
        this.rent = 250;
        this.worked = false;
    }

    

    public void addCredits(int amount) {
        this.credits += amount;
    } 

    public int numberOfCredits() {
        return this.credits;
    }

    public int getSalary() {
        return this.salary;
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }



     public boolean hasGifts() {

        return (this.gifts >= 1);
     }
     
     public void decreaseGifts() {
        this.gifts -= 1;
     }


}