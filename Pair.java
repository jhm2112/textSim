public class Pair {
    
    // Simple String-int pair for the store class
     
    private String product;
    private int price;

    public Pair(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public String getName() {
        return this.product;
    }

    public int getPrice() {
        return this.price;
    }
}
