import java.util.Vector;

/*
 * Class containing the testing
 */
public class CybSim {

    public static void main(String args[]) {
        Player p = new Player("Jorge");
        InitDays initializer = new InitDays();
        Vector<Day> days = initializer.initialize(p);

        for(int i = 0; i < days.size(); i++) {
            System.out.println("Day " + (i+1));
            days.get(i).executeEvent();
        }
        System.out.println("GAME ENDED");
        
    }
    
}
