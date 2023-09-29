import java.util.*;

/* A day is a tree of text nodes. This class contains the root and a method to execute a day
 * (allow the player to read the text and choose from different options)
*/
public class Day {
    private Node root;
    
    public Day(Node root, Player player) {
        this.root = root;
    }

    // This method allows the user to traverse the tree of text nodes and to choose from the different options 

    public void executeEvent () {
        Scanner input = new Scanner(System.in);
        Node curr = root;
        
        while(curr != null) {
            // Prints the text of the current node. If the number of children is greater than 1, display
            // the options and give the user the option to choose one of them
            System.out.println(curr.getText());
            if (curr.numChildren() > 1) {

                Vector<Node> children = curr.getChildren();
                for(int i = 0; i < children.size(); i++) {
                    System.out.println((i+1) + "- " + children.get(i).getText());
                }
                int choice = input.nextInt();
                while (choice < 1 || choice > children.size()) {
                    System.out.println("That's not an option!. Try again: ");
                    choice = input.nextInt();
                }
                Node old = curr;
                curr = curr.getChild(choice-1).getChild(0);
                old.deleteChild(choice-1);
            }
            // else, the only option is automatically chosen and printed
            else if (curr.numChildren() == 1) {
                System.out.println(curr.getChild(0).getText());
                curr = curr.getChild(0).getChild(0);
                curr.deleteChild(0);
            }
            // if the node is a sleep node (the day ends here), finish execution of the day
            else if (curr.isSleep()) {
                break;
            }
            // if we reach the end of a branch from the tree, return to the root and display the remaining options
            else if (curr.numChildren() == 0) {
                curr = this.root;
            }
            // case were we break
            else{
               curr = null; 
            } 
        }
        input.close();
    }  
}
