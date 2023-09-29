import java.util.LinkedList;
import java.util.Queue;

/* NPC class represents a character from the game and its attributes. It also contains useful
 * methods to interact and get info about the NPC. NPCs contain a list of events that can be
 * triggered if the points that the user has earned are enough.
 */
public class NPC {
    private String name;
    private int friendshipLevel;
    private int requiredLevel; // required level to go on a date
    private Queue<Day> dateEvents = new LinkedList<>();
    
    public NPC(String name, int id) {
        this.name = name;
        this.friendshipLevel = 0;
        this.requiredLevel = 1;
    }

    public void addDate(Day date) {
        dateEvents.add(date);
    }

    public void executeDate() {
        Day date = dateEvents.poll();
        if(date != null) {
            date.executeEvent();
        }
    }

    public void askForDate() {
        if(this.friendshipLevel >= this.requiredLevel) {
            this.requiredLevel += 1;
            System.out.println(this.name + " wants to go on a date!");
            this.executeDate();
        }
        else {
            System.out.println("You need " + this.requiredLevel + 
                " points for a date. You currently have " + this.friendshipLevel + "points");
        }
    }

    public void sendGift(Player p) {
        if(p.hasGifts()) {
            p.decreaseGifts();
            this.friendshipLevel += 1;
        }
        else {
            System.out.println("You don't have any gifts in your inventory");
        }
    }

    public String getName() {
        return this.name;
    }


    
}
