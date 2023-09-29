import java.util.*;

/* NPCList is a container for the NPCs of the game and also contains some useful methods to
 * modify and see the contents of the list
 */
public class NPCList {
    private Vector<NPC> npcs = new Vector<>();

    public void addNPC(NPC character) {
        this.npcs.add(character);
    }

    public void printNPCList() {
        int i = 1;
        for(NPC c : this.npcs) {
            System.out.println(i + " " + c.getName());
            i++;
        }
    }

    public void askForDate(int index) {
        this.npcs.get(index+1).askForDate();
    }
}
