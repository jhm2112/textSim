import java.util.Vector;

// A text node is the "standard" node that only contains text

public class TextNode implements Node {

    private Vector<Node> children = new Vector<>();
    private String text;
    private boolean isSleep = false;

    public TextNode(String text) {
        this.text = text;
    }

    public String getText() {
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
