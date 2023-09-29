import java.util.Vector;

// A work node displays text but also adds credits from working to the user
public class WorkNode implements Node {

    private Vector<Node> children = new Vector<>();
    private String text;
    private Player p;
    private boolean isSleep = false;

    public WorkNode(String text, Player p) {
        this.text = text;
        this.p = p;
    }

    public String getText() {
        p.addCredits(p.getSalary());
        return this.text;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public Vector<Node> getChildren() {
        return this.children;
    }

    public Node getChild(int index) {
        if(!this.hasChildren()) {
            return null;
        }
        return this.children.get(index);
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public int numChildren() {
        return this.children.size();
    }

    public void deleteChild(int index) {
        if( index < 0 || index >= children.size()) {
            return;
        }
        this.children.remove(index);
    }

    public void setSleep() {
        this.isSleep = true;
    }

    public boolean isSleep() {
        return this.isSleep;
    }
}
