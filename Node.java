import java.util.*;

/* Interface that serves to create other types of nodes with more functionalities  */

public interface Node {


    public String getText();

    
    public void addChild(Node child);

    public Vector<Node> getChildren();

    public Node getChild(int index);
    
    public boolean hasChildren();

    public int numChildren();

    public void deleteChild(int index);

    // method that specifies if a node ends the execution of the day (go to sleep)
    public void setSleep();

    public boolean isSleep();
}
