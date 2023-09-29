import java.util.Vector;

// Class that is used to initialize the data and variables for the test program

public class InitDays {

    public Day initializeDay1(Player p) {
        // root level
        final String t1 = "You are awake. You decide to: ";
        TextNode n1 = new TextNode(t1);
        
        // first level
        final String t2 = "Go To Work";
        final String t3 = "Watch the news";
        final String t4 = "Go To Sleep";

        TextNode n2 = new TextNode(t2);
        TextNode n3 = new TextNode(t3);
        TextNode n4 = new TextNode(t4); 
        n1.addChild(n2);
        n1.addChild(n3);
        n1.addChild(n4);
        // second level
        final String t21 = "You went to work [:";
        final String t31 = "Today's News: Ultra AI replaces AI, which had replaced humans decades ago";
        final String t41 = "Good Night";

        WorkNode n21 = new WorkNode(t21, p);
        TextNode n31 = new TextNode(t31);
        TextNode n41 = new TextNode(t41); 
        n41.setSleep();

        n2.addChild(n21);
        n3.addChild(n31);
        n4.addChild(n41);

        Day day1 = new Day(n1, p);

        return day1;

    }

    public Vector<Day> initialize(Player p) {
        Vector<Day> days = new Vector<Day>();
        days.add(initializeDay1(p));

        return days;
    }
    
}
